document.addEventListener('DOMContentLoaded', function() {
    controlDateRange();
    controlGuests();
    controlFilters();
    controlGuestSelectorPopup();
});

function controlGuestSelectorPopup() {
    const triggerButton = document.getElementById('guest-selector-trigger');
    const popup = document.getElementById('guest-selector-popup');
    const overlay = document.getElementById('guest-selector-overlay');
    const closeButton = document.getElementById('close-guest-selector');
    const updateButton = document.getElementById('update-guests');
    const guestSummary = document.getElementById('guest-summary');
    
    // Function to update the guest summary text
    function updateGuestSummaryText() {
        const adults = parseInt(document.getElementById('adults-count').textContent);
        const children = parseInt(document.getElementById('children-count').textContent);
        const toddlers = parseInt(document.getElementById('toddlers-count').textContent);
        
        guestSummary.textContent = `${adults} ${adults === 1 ? 'Adult' : 'Adults'}, ${children} ${children === 1 ? 'Child' : 'Children'}, ${toddlers} ${toddlers === 1 ? 'Toddler' : 'Toddlers'}`;
    }
    
    // Initialize summary text
    updateGuestSummaryText();
    
    // Open popup when button is clicked
    triggerButton.addEventListener('click', function() {
        popup.classList.remove('hidden');
        popup.classList.add('flex');
        document.body.classList.add('overflow-hidden'); // Prevent scrolling when popup is open
    });
    
    // Close popup when overlay is clicked
    overlay.addEventListener('click', function() {
        popup.classList.add('hidden');
        popup.classList.remove('flex');
        document.body.classList.remove('overflow-hidden');
    });
    
    // Close popup when close button is clicked
    closeButton.addEventListener('click', function() {
        popup.classList.add('hidden');
        popup.classList.remove('flex');
        document.body.classList.remove('overflow-hidden');
    }); 
    
    // Update and close popup when update button is clicked
    updateButton.addEventListener('click', function() {
        updateGuestSummaryText();
        popup.classList.add('hidden');
        popup.classList.remove('flex');
        document.body.classList.remove('overflow-hidden');
        
        const url = new URL(window.location.href);
        url.searchParams.set('adults', document.getElementById('adults-input').value);
        url.searchParams.set('children', document.getElementById('children-input').value);
        url.searchParams.set('toddlers', document.getElementById('toddlers-input').value);
        window.location.href = url.toString();
    });
    
    // Update summary when guest counts change
    document.querySelectorAll('.guest-btn').forEach(button => {
        button.addEventListener('click', function() {
            updateGuestSummaryText();
        });
    });
}

function updateGuestParams(adults, children, toddlers) {
    const urlParams = new URLSearchParams(window.location.search);
    
    // Update guest parameters
    urlParams.set('adults', adults);
    urlParams.set('children', children);
    urlParams.set('toddlers', toddlers);
    
    // Set babybed parameter based on toddlers count
    if (toddlers > 0) {
        urlParams.set('babybed', '1');
    } else {
        urlParams.delete('babybed');
    }
    
    // Update URL without page reload
    const newUrl = `${window.location.pathname}?${urlParams.toString()}`;
    window.history.pushState({}, '', newUrl);
}

function controlGuests() {
    // Get URL parameters or use defaults
    const urlParams = new URLSearchParams(window.location.search);
    let adults = parseInt(urlParams.get('adults')) || 2;
    let children = parseInt(urlParams.get('children')) || 0;
    let toddlers = parseInt(urlParams.get('toddlers')) || 0;

    // Ensure adults is at least 1
    adults = Math.max(1, Math.min(adults, 4));
    // Ensure children is not negative and doesn't exceed max with adults
    children = Math.max(0, children);
    // Ensure toddlers is between 0 and 2
    toddlers = Math.max(0, Math.min(toddlers, 2));

    // Update the UI with initial values
    document.getElementById('adults-count').textContent = adults;
    document.getElementById('adults-input').value = adults;
    document.getElementById('children-count').textContent = children;
    document.getElementById('children-input').value = children;
    document.getElementById('toddlers-count').textContent = toddlers;
    document.getElementById('toddlers-input').value = toddlers;

    const updateButtons = (type) => {
        const count = parseInt(document.getElementById(`${type}-count`).textContent);
        const minusBtn = document.querySelector(`button.minus[data-type="${type}"]`);
        const plusBtn = document.querySelector(`button.plus[data-type="${type}"]`);
        
        // Update minus button state
        minusBtn.disabled = type === 'adults' ? count <= 1 : count <= 0;
        
        // Update plus button state based on total guests
        const adultsCount = parseInt(document.getElementById('adults-count').textContent);
        const childrenCount = parseInt(document.getElementById('children-count').textContent);
        
        if (type === 'adults') {
            plusBtn.disabled = adultsCount >= 4 || (adultsCount + childrenCount) >= 4;
        } else if (type === 'children') {
            plusBtn.disabled = (adultsCount + childrenCount) >= 4;
        } else if (type === 'toddlers') {
            plusBtn.disabled = count >= 2;
        }
    };

    document.querySelectorAll('.guest-btn').forEach(button => {
        button.addEventListener('click', function() {
            const type = this.getAttribute('data-type');
            const countElement = document.getElementById(`${type}-count`);
            const inputElement = document.getElementById(`${type}-input`);
            let count = parseInt(countElement.textContent);
            const adultsCount = parseInt(document.getElementById('adults-count').textContent);
            const childrenCount = parseInt(document.getElementById('children-count').textContent);
            const totalGuests = adultsCount + childrenCount;

            if (this.classList.contains('plus')) {
                // Only allow adding if it doesn't exceed maximums
                if (type === 'adults' && adultsCount < 4 && totalGuests < 4) {
                    count++;
                } else if (type === 'children' && totalGuests < 4) {
                    count++;
                } else if (type === 'toddlers' && count < 2) {
                    count++;
                }
            } else if (this.classList.contains('minus') && count > (type === 'adults' ? 1 : 0)) {
                count--;
            }

            countElement.textContent = count;
            inputElement.value = count;
            
            // Update URL with new guest counts using the latest values after increment/decrement
            updateGuestParams(
                parseInt(document.getElementById('adults-count').textContent),
                parseInt(document.getElementById('children-count').textContent),
                parseInt(document.getElementById('toddlers-count').textContent)
            );
            
            // Update all buttons after any change
            updateButtons('adults');
            updateButtons('children');
            updateButtons('toddlers');
        });
    });

    // Update search button click handler is now handled in controlGuestSelectorPopup()

    // Initialize buttons state
    updateButtons('adults');
    updateButtons('children');
    updateButtons('toddlers');
}

function controlDateRange() {
    const dateRangeInput = document.querySelector('input[name="daterange"]');
    console.log(dateRangeInput);
    if (!dateRangeInput) return;

    console.log(dateRangeInput);

    const urlParams = new URLSearchParams(window.location.search);
    const startDate = urlParams.get('start_date') || dateRangeInput.dataset.startDate;
    const endDate = urlParams.get('end_date') || dateRangeInput.dataset.endDate;
    
    $(dateRangeInput).daterangepicker({
        opens: 'left',
        startDate: moment(startDate, 'DD/MM/YYYY'),
        endDate: moment(endDate, 'DD/MM/YYYY'),
        minDate: moment().add(1, 'days'),
        maxDate: moment().add(1, 'years'),
        locale: {
            format: 'DD/MM/YYYY'
        },
        // Custom styling options
        autoApply: true,
        showDropdowns: true,
        linkedCalendars: false,
        
        // Apply custom classes for styling
        applyButtonClasses: 'bg-blue-600 hover:bg-blue-700',
        cancelButtonClasses: 'bg-gray-400 hover:bg-gray-500',
        buttonClasses: 'btn',
        containerClass: 'custom-daterangepicker'
    }, function(start, end) {
        const newStart = start.format('DD/MM/YYYY');
        const newEnd = end.format('DD/MM/YYYY');
        const url = new URL(window.location.href);
        url.searchParams.set('start_date', newStart);
        url.searchParams.set('end_date', newEnd);
        window.location.href = url.toString();
    });
    dateRangeInput.value = startDate + ' - ' + endDate;
}

function controlFilters() {
    const allInput = document.querySelectorAll('input[type="radio"], input[type="checkbox"]');
    allInput.forEach(input => {
        input.addEventListener('change', function () {
            const url = new URL(window.location.href);
            if (this.type === 'checkbox') {
                url.searchParams.set(this.name, this.checked ? 'true' : 'false');
            } else {
                url.searchParams.set(this.name, this.value);
            }
            window.location.href = url.toString();
        });
    });

    const urlParams = new URLSearchParams(window.location.search);
    for (const [key, value] of urlParams) {
        const input = document.querySelector(`input[name="${key}"]`);
        if (input) {
            if (input.type === 'checkbox') {
                input.checked = value === 'true';
            } else if (input.type === 'radio') {
                // For radio buttons, we need to uncheck all others in the group
                const radioGroup = document.querySelectorAll(`input[name="${key}"]`);
                radioGroup.forEach(radio => {
                    radio.checked = radio.value === value;
                });
            }
        }
    }
}

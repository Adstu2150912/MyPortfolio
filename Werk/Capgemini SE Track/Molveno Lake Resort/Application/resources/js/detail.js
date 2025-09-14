document.addEventListener('DOMContentLoaded', function() {
    // Check if we should auto-open the booking modal for newly registered users
    const urlParams = new URLSearchParams(window.location.search);
    const shouldAutoBook = urlParams.get('auto_book') === '1';
    
    // Handle disability checkbox for authenticated user
    const hasDisabilityAuthCheckbox = document.getElementById('has-disability-auth');
    if (hasDisabilityAuthCheckbox) {
        hasDisabilityAuthCheckbox.addEventListener('change', function() {
            // The value will be submitted directly with the form
        });
    }
    
    // Handle disability checkbox for guest form
    const hasDisabilityGuestCheckbox = document.getElementById('has-disability-guest');
    const disabilityFormInput = document.getElementById('disability-form');
    if (hasDisabilityGuestCheckbox && disabilityFormInput) {
        hasDisabilityGuestCheckbox.addEventListener('change', function() {
            disabilityFormInput.value = this.checked ? '1' : '0';
        });
    }
    
    const authModal = document.getElementById('auth-modal');
    const bookNowBtn = document.getElementById('book-now-btn');
    const closeAuthModalBtn = document.getElementById('close-auth-modal');
    const closeModalBtn = document.getElementById('close-modal');
    const continueGuest = document.getElementById('continue-guest');
    const guestModal = document.getElementById('guest-info-modal');
    const closeGuestModal = document.getElementById('close-guest-modal');
    
    // Auto-open booking modal if user just registered
    if (shouldAutoBook && authModal) {
        authModal.classList.remove('hidden');
        authModal.classList.add('flex');
        document.body.style.overflow = 'hidden';
        
        // Remove the auto_book parameter from URL without page reload
        if (window.history.replaceState) {
            const newUrl = window.location.href.replace(/([?&])auto_book=1(&|$)/, function(match, p1, p2) {
                return p2 ? p1 : '';
            });
            window.history.replaceState(null, '', newUrl);
        }
    }
    
    if (bookNowBtn) {
        bookNowBtn.addEventListener('click', function() {
            if (guestModal) {
                guestModal.classList.add('hidden');
                guestModal.classList.remove('flex');
            }
            if (authModal) {
                authModal.classList.remove('hidden');
                authModal.classList.add('flex');
            }
            document.body.style.overflow = 'hidden';
        });
    }
    
    // Only close the auth modal when clicking the background, not on its contents
    authModal.addEventListener('click', function(e) {
        if (e.target === authModal) {
            closeAuthModalHandler();
        }
    });
    
    if (closeAuthModalBtn) {
        closeAuthModalBtn.addEventListener('click', closeAuthModalHandler);
    }
    
    if (closeModalBtn) {
        closeModalBtn.addEventListener('click', closeAuthModalHandler);
    }
    
    // Prevent clicks inside the auth modal form from closing the modal
    const authModalForm = document.querySelector('#auth-modal form');
    if (authModalForm) {
        authModalForm.addEventListener('click', function(e) {
            e.stopPropagation();
        });
    }
    
    if (continueGuest) {
        continueGuest.addEventListener('click', function(e) {
            e.preventDefault();
            if (authModal) {
                authModal.classList.add('hidden');
                authModal.classList.remove('flex');
            }
            if (guestModal) {
                guestModal.classList.remove('hidden');
                guestModal.classList.add('flex');
            }
            document.body.style.overflow = 'hidden';
        });
    }
    
    if (closeGuestModal) {
        closeGuestModal.addEventListener('click', closeGuestModalHandler);
    }

    // Combine first and last name into hidden full name field before submitting guest form
    const guestForm = document.getElementById('guest-info-form');
    if (guestForm) {
        guestForm.addEventListener('submit', function() {
            const firstName = document.getElementById('guest-first-name').value.trim();
            const lastName = document.getElementById('guest-last-name').value.trim();
            document.getElementById('guest-full-name').value = `${firstName} ${lastName}`.trim();
        });
        
        // Prevent clicks inside the guest form from closing the modal
        guestForm.addEventListener('click', function(e) {
            e.stopPropagation();
        });
    }
    
    // Only close the guest modal when clicking the background
    guestModal.addEventListener('click', function(e) {
        if (e.target === guestModal) {
            closeGuestModalHandler();
        }
    });
    
    document.addEventListener('keydown', function(e) {
        if (e.key === 'Escape') {
            if (!guestModal.classList.contains('hidden')) {
                closeGuestModalHandler();
            } else if (!authModal.classList.contains('hidden')) {
                closeAuthModalHandler();
            }
        }
    });

    // Breakfast toggle handling: sync hidden inputs and update totals/visibility
    const breakfastCheckbox = document.getElementById('breakfast');
    const includesBreakfastAuth = document.getElementById('includes_breakfast_auth');
    const includesBreakfastGuest = document.getElementById('breakfast-form');
    const breakfastRatesSegment = document.getElementById('breakfast_rates_segment');
    const totalPriceValue = document.getElementById('total_price_value');
    const authTotalPriceValue = document.getElementById('auth_total_price_value');
    const guestTotalPriceValue = document.getElementById('guest_total_price_value');
    const priceData = document.getElementById('price_data');
    const authTotalHidden = document.querySelector('#auth-booking-form input[name="total_price"]');
    const guestTotalHidden = document.querySelector('#guest-info-form input[name="total_price"]');

    function updateBreakfastState() {
        if (!breakfastCheckbox || !priceData) return;
        const isChecked = breakfastCheckbox.checked;
        // Sync hidden includes_breakfast fields
        if (includesBreakfastAuth) includesBreakfastAuth.value = isChecked ? '1' : '0';
        if (includesBreakfastGuest) includesBreakfastGuest.value = isChecked ? '1' : '0';
        // Toggle breakfast breakdown visibility
        if (breakfastRatesSegment) {
            breakfastRatesSegment.style.display = isChecked ? '' : 'none';
        }
        // Update totals
        const withB = priceData.dataset.totalWithBreakfast;
        const withoutB = priceData.dataset.totalWithoutBreakfast;
        const selectedTotal = isChecked ? withB : withoutB;
        const euro = '€';
        if (totalPriceValue) totalPriceValue.textContent = euro + selectedTotal;
        if (authTotalPriceValue) authTotalPriceValue.textContent = euro + selectedTotal;
        if (guestTotalPriceValue) guestTotalPriceValue.textContent = euro + selectedTotal;
        if (authTotalHidden) authTotalHidden.value = selectedTotal;
        if (guestTotalHidden) guestTotalHidden.value = selectedTotal;
    }

    // Initialize state on load
    updateBreakfastState();
    if (breakfastCheckbox) {
        breakfastCheckbox.addEventListener('change', updateBreakfastState);
    }

    // Submit-time sync to ensure hidden fields reflect the latest toggle state
    const authForm = document.getElementById('auth-booking-form');
    if (authForm) {
        authForm.addEventListener('submit', function() {
            if (includesBreakfastAuth && breakfastCheckbox) {
                includesBreakfastAuth.value = breakfastCheckbox.checked ? '1' : '0';
            }
        });
    }
    if (guestForm) {
        guestForm.addEventListener('submit', function() {
            if (includesBreakfastGuest && breakfastCheckbox) {
                includesBreakfastGuest.value = breakfastCheckbox.checked ? '1' : '0';
            }
        });
    }

    function closeAuthModalHandler() {
        authModal.classList.add('hidden');
        authModal.classList.remove('flex');
        document.body.style.overflow = 'auto';
    }

    function closeGuestModalHandler() {
        guestModal.classList.add('hidden');
        guestModal.classList.remove('flex');
        document.body.style.overflow = 'auto';
    }
});
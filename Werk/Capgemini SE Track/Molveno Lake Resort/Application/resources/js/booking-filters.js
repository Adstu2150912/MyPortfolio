document.addEventListener('DOMContentLoaded', function() {
    // Initialize filter controls
    initializeFilters();
});

function initializeFilters() {
    // Get filter elements
    const roomTypeFilter = document.getElementById('room_type');
    const viewFilter = document.getElementById('view');
    const singleBedFilter = document.getElementById('single');
    const doubleBedFilter = document.getElementById('double');
    const accessibleFilter = document.getElementById('accessible');
    const babybedFilter = document.getElementById('babybed_filter');
    
    // Add event listeners to filters for immediate client-side filtering
    roomTypeFilter.addEventListener('change', applyFilters);
    viewFilter.addEventListener('change', applyFilters);
    singleBedFilter.addEventListener('change', applyFilters);
    doubleBedFilter.addEventListener('change', applyFilters);
    accessibleFilter.addEventListener('change', applyFilters);
    babybedFilter.addEventListener('change', applyFilters);
    
    // Add event listeners to people count elements
    document.getElementById('adults').addEventListener('change', applyFilters);
    document.getElementById('adults').addEventListener('input', applyFilters);
    document.getElementById('children').addEventListener('change', applyFilters);
    document.getElementById('children').addEventListener('input', applyFilters);

    // Handle the plus and minus buttons
    document.querySelectorAll('button[onclick^="increment"]').forEach(button => {
        button.addEventListener('click', function() {
            setTimeout(applyFilters, 10);
        });
    });
    document.querySelectorAll('button[onclick^="decrement"]').forEach(button => {
        button.addEventListener('click', function() {
            setTimeout(applyFilters, 10);
        });
    });

    // Initial filtering on page load
    applyFilters();
}

// Function to apply filters
function applyFilters() {
    const roomTypeFilter = document.getElementById('room_type');
    const viewFilter = document.getElementById('view');
    const singleBedFilter = document.getElementById('single');
    const doubleBedFilter = document.getElementById('double');
    const accessibleFilter = document.getElementById('accessible');
    const babybedFilter = document.getElementById('babybed_filter');
    
    const roomType = roomTypeFilter.value;
    const view = viewFilter.value;
    const singleBed = singleBedFilter.checked;
    const doubleBed = doubleBedFilter.checked;
    const accessible = accessibleFilter.checked;
    const babybed = babybedFilter.checked;
    
    // Get people count for capacity filtering
    const adults = parseInt(document.getElementById('adults').value) || 0;
    const children = parseInt(document.getElementById('children').value) || 0;
    const totalPeople = adults + children; // Toddlers don't count toward capacity

    // Get all room rows
    const roomRows = document.querySelectorAll('.room-row');
    let visibleCount = 0;

    // Filter each room
    roomRows.forEach(row => {
        let showRoom = true;

        // Apply room type filter
        if (roomType !== '0') {
            if (row.dataset.roomType !== roomType) {
                showRoom = false;
            }
        }

        // Apply view filter
        if (view !== '0') {
            if (row.dataset.view !== view) {
                showRoom = false;
            }
        }
        
        // Apply capacity filter based on total people count
        if (totalPeople > 0) {
            const capacity = parseInt(row.dataset.capacity) || 0;
            if (capacity < totalPeople) {
                showRoom = false;
            }
        }

        // Apply bed type filters
        let hasSingleBed = false;
        let hasDoubleBed = false;
        
        try {
            // Parse the JSON data for bed types
            const bedTypesData = JSON.parse(row.dataset.bedTypes);
            
            // Check each bed in the array of beds
            for (let i = 0; i < bedTypesData.length; i++) {
                const bed = bedTypesData[i];
                // Check if bed data exists and has type information
                if (bed && bed.type) {
                    const bedType = String(bed.type).toLowerCase();
                    if (bedType.includes('single')) {
                        hasSingleBed = true;
                    }
                    if (bedType.includes('double')) {
                        hasDoubleBed = true;
                    }
                }
            }
        } catch (e) {
            console.error('Error parsing bed types for room ' + row.dataset.roomNumber + ':', e);
        }
        
        // Apply bed type filters only if at least one is checked
        // If both are unchecked, don't filter by bed type
        if (singleBed || doubleBed) {
            if (singleBed && !hasSingleBed && doubleBed && !hasDoubleBed) {
                showRoom = false;
            } else if (singleBed && !hasSingleBed && !doubleBed) {
                showRoom = false;
            } else if (!singleBed && doubleBed && !hasDoubleBed) {
                showRoom = false;
            }
        }

        // Apply accessibility filter
        if (accessible && row.dataset.accessible !== 'true') {
            showRoom = false;
        }
        
        // Apply baby bed filter
        if (babybed && row.dataset.babybed !== 'true') {
            showRoom = false;
        }
        
        // Show or hide the room based on filters
        if (showRoom) {
            row.style.display = '';
            visibleCount++;
        } else {
            row.style.display = 'none';
        }
    });

    // Show message if no rooms match filters
    const noRoomsMessage = document.querySelector('.bg-yellow-50.border.border-yellow-200');
    if (noRoomsMessage) {
        if (visibleCount === 0 && roomRows.length > 0) {
            noRoomsMessage.style.display = '';
        } else {
            noRoomsMessage.style.display = 'none';
        }
    }
}

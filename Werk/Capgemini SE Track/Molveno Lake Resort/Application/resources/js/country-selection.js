/**
 * Country selection functionality for registration form
 * Handles showing/hiding custom country input when "Other" is selected
 * Also handles custom country code for phone numbers
 */

// Initialize on page load
document.addEventListener('DOMContentLoaded', function() {
    // Get the form element
    const form = document.querySelector('form');
    
    // Add form submission handler
    if (form) {
        form.addEventListener('submit', function(e) {
            const countryCodeSelect = document.getElementById('country_code_select');
            const customCountryCodeInput = document.getElementById('custom_country_code');
            const hiddenCountryCodeInput = document.getElementById('country_code');
            
            if (countryCodeSelect && countryCodeSelect.value === 'custom' && customCountryCodeInput) {
                // Validate custom country code format
                const customCode = customCountryCodeInput.value;
                const codePattern = /^\+[0-9]{1,4}$/;
                
                if (!codePattern.test(customCode)) {
                    e.preventDefault(); // Prevent form submission
                    alert('Please enter a valid country code (e.g., +123)');
                    customCountryCodeInput.focus();
                    return false;
                }
                
                // Set the hidden input value to the custom country code
                if (hiddenCountryCodeInput) {
                    hiddenCountryCodeInput.value = customCode;
                }
            }
        });
    }

    function toggleCustomCountry() {
        const selectElement = document.getElementById('country_select');
        const customCountryDiv = document.getElementById('custom_country_div');
        const customCountryInput = document.getElementById('custom_country');
        const hiddenCountryInput = document.getElementById('country');
        
        if (selectElement && customCountryDiv && customCountryInput && hiddenCountryInput) {
            if (selectElement.value === 'other') {
                customCountryDiv.style.display = 'block';
                customCountryInput.setAttribute('required', 'required');
                hiddenCountryInput.value = '';
            } else {
                customCountryDiv.style.display = 'none';
                customCountryInput.removeAttribute('required');
                hiddenCountryInput.value = selectElement.value;
            }
        }
    }
    
    function toggleCustomCountryCode() {
        const selectElement = document.getElementById('country_code_select');
        const customCountryCodeDiv = document.getElementById('custom_country_code_div');
        const customCountryCodeInput = document.getElementById('custom_country_code');
        const hiddenCountryCodeInput = document.getElementById('country_code');
        
        if (selectElement && customCountryCodeDiv && customCountryCodeInput && hiddenCountryCodeInput) {
            if (selectElement.value === 'custom') {
                customCountryCodeDiv.style.display = 'block';
                customCountryCodeInput.setAttribute('required', 'required');
                // Set the hidden input to the current value of the custom input if it exists
                if (customCountryCodeInput.value) {
                    hiddenCountryCodeInput.value = customCountryCodeInput.value;
                } else {
                    hiddenCountryCodeInput.value = '';
                }
            } else {
                customCountryCodeDiv.style.display = 'none';
                customCountryCodeInput.removeAttribute('required');
                hiddenCountryCodeInput.value = selectElement.value;
            }
        }
    }

    // Handle country selection
    const selectElement = document.getElementById('country_select');
    if (selectElement) {
        toggleCustomCountry();
        selectElement.addEventListener('change', toggleCustomCountry);

        // Update hidden field when custom country changes
        const customCountryInput = document.getElementById('custom_country');
        if (customCountryInput) {
            customCountryInput.addEventListener('input', function() {
                const hiddenCountryInput = document.getElementById('country');
                if (hiddenCountryInput) {
                    hiddenCountryInput.value = this.value;
                }
            });
        }
    }
    
    // Handle country code selection
    const countryCodeSelect = document.getElementById('country_code_select');
    if (countryCodeSelect) {
        // Initialize the hidden field with the selected value
        const hiddenCountryCodeInput = document.getElementById('country_code');
        if (hiddenCountryCodeInput && countryCodeSelect.value !== 'custom') {
            hiddenCountryCodeInput.value = countryCodeSelect.value;
        }
        
        toggleCustomCountryCode();
        countryCodeSelect.addEventListener('change', toggleCustomCountryCode);

        // Update hidden field when custom country code changes
        const customCountryCodeInput = document.getElementById('custom_country_code');
        if (customCountryCodeInput) {
            // Add input validation to ensure it starts with + and contains only numbers
            customCountryCodeInput.addEventListener('input', function() {
                // Ensure the input starts with a + sign
                if (this.value && !this.value.startsWith('+')) {
                    this.value = '+' + this.value;
                }
                
                // Remove any non-numeric characters after the + sign
                this.value = '+' + this.value.substring(1).replace(/[^0-9]/g, '');
                
                const hiddenCountryCodeInput = document.getElementById('country_code');
                if (hiddenCountryCodeInput) {
                    hiddenCountryCodeInput.value = this.value;
                }
            });
        }
    }
});
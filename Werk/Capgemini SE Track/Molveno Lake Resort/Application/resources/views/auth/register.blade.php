<x-guest-layout >
    @vite(['resources/js/country-selection.js'])
    <form method="POST" action="{{ route('register') }}">
        @csrf
        @if(request('redirect_to'))
            <input type="hidden" name="redirect_to" value="{{ request('redirect_to') }}">
        @endif
        <div style="padding: 2em">
            <!-- Name -->
            <div>
                <x-input-label for="name" :value="__('Full name')" />
                <x-text-input id="name" class="block mt-1 w-full" type="text" name="name" :value="old('name')" required autofocus autocomplete="name" />
                <x-input-error :messages="$errors->get('name')" class="mt-2" />
            </div>

            <!-- Email Address -->
            <div class="mt-4">
                <x-input-label for="email" :value="__('Email')" />
                <x-text-input id="email" class="block mt-1 w-full" type="email" name="email" :value="old('email')" required autocomplete="username" />
                <x-input-error :messages="$errors->get('email')" class="mt-2" />
            </div>

            <!-- Phone Number with Country Code -->
            <div class="mt-4">
                <x-input-label for="phone_number" :value="__('Phone Number')" />
                <div class="flex flex-col">
                    <div class="flex">
                    <select name="country_code_select" id="country_code_select" class="rounded-l-md border-gray-300 dark:border-gray-700 dark:bg-gray-900 dark:text-gray-300 focus:border-indigo-500 dark:focus:border-indigo-600 focus:ring-indigo-500 dark:focus:ring-indigo-600 shadow-sm" style="width: 120px">
                        <option value="+1" {{ old('country_code') == '+1' ? 'selected' : '' }}>+1 (US/CA)</option>
                        <option value="+31" {{ old('country_code') == '+31' ? 'selected' : '' }}>+31 (NL)</option>
                        <option value="+32" {{ old('country_code') == '+32' ? 'selected' : '' }}>+32 (BE)</option>
                        <option value="+33" {{ old('country_code') == '+33' ? 'selected' : '' }}>+33 (FR)</option>
                        <option value="+34" {{ old('country_code') == '+34' ? 'selected' : '' }}>+34 (ES)</option>
                        <option value="+39" {{ old('country_code') == '+39' ? 'selected' : '' }}>+39 (IT)</option>
                        <option value="+41" {{ old('country_code') == '+41' ? 'selected' : '' }}>+41 (CH)</option>
                        <option value="+43" {{ old('country_code') == '+43' ? 'selected' : '' }}>+43 (AT)</option>
                        <option value="+44" {{ old('country_code') == '+44' ? 'selected' : '' }}>+44 (GB)</option>
                        <option value="+45" {{ old('country_code') == '+45' ? 'selected' : '' }}>+45 (DK)</option>
                        <option value="+46" {{ old('country_code') == '+46' ? 'selected' : '' }}>+46 (SE)</option>
                        <option value="+47" {{ old('country_code') == '+47' ? 'selected' : '' }}>+47 (NO)</option>
                        <option value="+48" {{ old('country_code') == '+48' ? 'selected' : '' }}>+48 (PL)</option>
                        <option value="+49" {{ old('country_code') == '+49' ? 'selected' : '' }}>+49 (DE)</option>
                        <option value="+351" {{ old('country_code') == '+351' ? 'selected' : '' }}>+351 (PT)</option>
                        <option value="+352" {{ old('country_code') == '+352' ? 'selected' : '' }}>+352 (LU)</option>
                        <option value="+353" {{ old('country_code') == '+353' ? 'selected' : '' }}>+353 (IE)</option>
                        <option value="+358" {{ old('country_code') == '+358' ? 'selected' : '' }}>+358 (FI)</option>
                        <option value="+420" {{ old('country_code') == '+420' ? 'selected' : '' }}>+420 (CZ)</option>
                        <option value="custom" {{ old('custom_country_code') ? 'selected' : '' }}>Other</option>
                    </select>
                    <x-text-input id="phone_number" class="block mt-0 w-full rounded-l-none" type="tel" name="phone_number" :value="old('phone_number')" required placeholder="123456789" />
                    </div>
                    
                    <!-- Custom country code input -->
                    <div id="custom_country_code_div" class="mt-2" style="display: {{ old('custom_country_code') ? 'block' : 'none' }}">
                        <x-input-label for="custom_country_code" :value="__('Enter country code (with + symbol)')" />
                        <x-text-input id="custom_country_code" class="block mt-1 w-full" type="text" name="custom_country_code" :value="old('custom_country_code')" placeholder="+123" pattern="\+[0-9]{1,4}" title="Country code must start with + followed by 1-4 digits" />
                    </div>
                    
                    <!-- Hidden field to store the actual country code value -->
                    <input type="hidden" id="country_code" name="country_code" value="{{ old('country_code') }}">
                </div>
                <x-input-error :messages="$errors->get('phone_number')" class="mt-2" />
                <x-input-error :messages="$errors->get('country_code')" class="mt-2" />
                <x-input-error :messages="$errors->get('custom_country_code')" class="mt-2" />
            </div>

            <!-- Date of Birth -->
            <div class="mt-4">
                <x-input-label for="date_of_birth" :value="__('Date of Birth (Must be 18+)')" />
                <x-text-input id="date_of_birth" class="block mt-1 w-full" type="date" name="date_of_birth" :value="old('date_of_birth')" required max="{{ date('Y-m-d', strtotime('-18 years')) }}" />
                <x-input-error :messages="$errors->get('date_of_birth')" class="mt-2" />
                <p class="text-sm text-gray-600 dark:text-gray-400 mt-1">You must be at least 18 years old to register</p>
            </div>

            <!-- Address Fields -->
            <div class="mt-4">
                <x-input-label for="street" :value="__('Street Address')" />
                <x-text-input id="street" class="block mt-1 w-full" type="text" name="street" :value="old('street')" required placeholder="Street name and number" />
                <x-input-error :messages="$errors->get('street')" class="mt-2" />
            </div>

            <div class="mt-4 flex space-x-2">
                <div class="w-1/2">
                    <x-input-label for="postal_code" :value="__('Postal Code')" />
                    <x-text-input id="postal_code" class="block mt-1 w-full" type="text" name="postal_code" :value="old('postal_code')" required placeholder="1234 AB" />
                    <x-input-error :messages="$errors->get('postal_code')" class="mt-2" />
                </div>
                <div class="w-1/2">
                    <x-input-label for="city" :value="__('City')" />
                    <x-text-input id="city" class="block mt-1 w-full" type="text" name="city" :value="old('city')" required />
                    <x-input-error :messages="$errors->get('city')" class="mt-2" />
                </div>
            </div>

            <div class="mt-4">
                <x-input-label for="country_select" :value="__('Country')" />
                <div class="country-selection">
                    <select id="country_select" class="block mt-1 w-full rounded-md border-gray-300 dark:border-gray-700 dark:bg-gray-900 dark:text-gray-300 focus:border-indigo-500 dark:focus:border-indigo-600 focus:ring-indigo-500 dark:focus:ring-indigo-600 shadow-sm">
                        <option value="" disabled {{ old('country') && old('country') != 'other' ? '' : 'selected' }}>Select your country</option>
                        <option value="Netherlands" {{ old('country') == 'Netherlands' ? 'selected' : '' }}>Netherlands</option>
                        <option value="Belgium" {{ old('country') == 'Belgium' ? 'selected' : '' }}>Belgium</option>
                        <option value="Germany" {{ old('country') == 'Germany' ? 'selected' : '' }}>Germany</option>
                        <option value="France" {{ old('country') == 'France' ? 'selected' : '' }}>France</option>
                        <option value="United Kingdom" {{ old('country') == 'United Kingdom' ? 'selected' : '' }}>United Kingdom</option>
                        <option value="Spain" {{ old('country') == 'Spain' ? 'selected' : '' }}>Spain</option>
                        <option value="Italy" {{ old('country') == 'Italy' ? 'selected' : '' }}>Italy</option>
                        <option value="Switzerland" {{ old('country') == 'Switzerland' ? 'selected' : '' }}>Switzerland</option>
                        <option value="Austria" {{ old('country') == 'Austria' ? 'selected' : '' }}>Austria</option>
                        <option value="Denmark" {{ old('country') == 'Denmark' ? 'selected' : '' }}>Denmark</option>
                        <option value="Sweden" {{ old('country') == 'Sweden' ? 'selected' : '' }}>Sweden</option>
                        <option value="Norway" {{ old('country') == 'Norway' ? 'selected' : '' }}>Norway</option>
                        <option value="Finland" {{ old('country') == 'Finland' ? 'selected' : '' }}>Finland</option>
                        <option value="Portugal" {{ old('country') == 'Portugal' ? 'selected' : '' }}>Portugal</option>
                        <option value="Ireland" {{ old('country') == 'Ireland' ? 'selected' : '' }}>Ireland</option>
                        <option value="United States" {{ old('country') == 'United States' ? 'selected' : '' }}>United States</option>
                        <option value="Canada" {{ old('country') == 'Canada' ? 'selected' : '' }}>Canada</option>
                        <option value="other" {{ old('custom_country') ? 'selected' : '' }}>Other (specify)</option>
                    </select>
                    
                    <div id="custom_country_div" class="mt-2" style="display: {{ old('custom_country') ? 'block' : 'none' }}">
                        <x-input-label for="custom_country" :value="__('Enter your country')" />
                        <x-text-input id="custom_country" class="block mt-1 w-full" type="text" name="custom_country" :value="old('custom_country')" />
                    </div>
                    
                    <!-- Hidden field to store the actual country value -->
                    <input type="hidden" id="country" name="country" value="{{ old('country') }}">
                </div>
                <x-input-error :messages="$errors->get('country')" class="mt-2" />
                <x-input-error :messages="$errors->get('custom_country')" class="mt-2" />
            </div>

            <!-- Password -->
            <div class="mt-4">
                <x-input-label for="password" :value="__('Password')" />

                <x-text-input id="password" class="block mt-1 w-full"
                                type="password"
                                name="password"
                                required autocomplete="new-password" />

                <x-input-error :messages="$errors->get('password')" class="mt-2" />
            </div>

            <!-- Confirm Password -->
            <div class="mt-4">
                <x-input-label for="password_confirmation" :value="__('Confirm Password')" />

                <x-text-input id="password_confirmation" class="block mt-1 w-full"
                                type="password"
                                name="password_confirmation" required autocomplete="new-password" />

                <x-input-error :messages="$errors->get('password_confirmation')" class="mt-2" />
            </div>

            <div class="flex items-center justify-end mt-4">
                <a class="underline text-sm text-gray-600 dark:text-gray-400 hover:text-gray-900 dark:hover:text-gray-100 rounded-md focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:focus:ring-offset-gray-800" href="{{ route('login') }}">
                    {{ __('Already registered?') }}
                </a>

                <x-primary-button class="ms-4">
                    {{ __('Register') }}
                </x-primary-button>
            </div>
        </div>
    </form>
</x-guest-layout>

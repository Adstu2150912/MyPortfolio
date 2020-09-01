/************************** Module Header *******************************\
Project:         Unit testen
Auteur:          Adam Oubelkas
Aanmaakdatum:    20 juni 2018
Module naam:     BankAccountTests.cs

Omschrijving:    Unit testen bankaccount

\************************************************************************/

using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BankAccountNS;

namespace BankTests
{
    [TestClass]
    public class BankAccountTests
    {
        /*
         * Debit only if the difference between pre-debit and post-debit equals 0.001 or greater
         */
        [TestMethod]
        public void Debit_WithValidAmount_UpdatesBalance()
        {
            // Arrange
            double beginningBalance = 11.99;
            double debitAmount = 4.55;
            double expected = 7.44;
            BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

            // Act
            account.Debit(debitAmount);

            // Assert
            double actual = account.Balance;
            Assert.AreEqual(expected, actual, 0.001, "Account not debited correctly");
        }

        /*
         * Debit only if the debitamount is greater than zero
         */
        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void Debit_WhenAmountIsLessThanZero_ShouldThrowArgumentOutOfRange()
        {
            // Arrange
            double beginningBalance = 11.99;
            double debitAmount = -100.00;
            BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

            // Act
            account.Debit(debitAmount);

            // Assert is handled by the ExpectedException attribute on the test method.
        }

        /*
         * Debit only if the debitamount is less than the balance
         */
        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void Debit_WhenAmountIsMoreThanBalance_ShouldThrowArgumentOutOfRange()
        {
            // Arrange
            double beginningBalance = 11.99;
            double debitAmount = 100.00;
            BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);

            // Act
            account.Debit(debitAmount);

            Assert.Fail("The expected exception was not thrown.");
        }

        /*
         * Credit only if the account is not frozen
         */
        [TestMethod]
        public void Credit_WhenAccountIsUnfrozen()
        {
            double beginnningBalance = 25.98;
            double creditAmount = 0.02;
            BankAccount account = new BankAccount("Mr. John Doe", beginnningBalance);

            account.Credit(account.Balance, creditAmount);
        }

        /*
         * Throw exception if the customername is empty
         */
        [TestMethod]
        public void IsEmpty_Customername()
        {
            double Balance = 0.00;
            BankAccount account = new BankAccount("", Balance);

            Assert.AreEqual(account.CustomerName, "");
        }

    }
}

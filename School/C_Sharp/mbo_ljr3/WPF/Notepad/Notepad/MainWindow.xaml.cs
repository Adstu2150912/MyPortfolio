/************************** Module Header *******************************\
Project:         Notepad Demo(WPF)
Auteur:          Adam Oubelkas
Aanmaakdatum:    23 september 2018
Module naam:     MainWindow.xaml.cs

Omschrijving:    Hoofdprogramma

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO; // voor het gebruik van klasse 'Stream'
using Microsoft.Win32; // voor het gebruik van bestandvenster klasses

namespace Notepad
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        // constructor
        public MainWindow()
        {
            InitializeComponent();
        }

        //variabel waarmee bepaald wordt of invoer tekstveld veranderd is
        public bool txtInputChanged = false;

        // event wordt aangeroepen nadat erop menuitem 'Save' geklikt is
        public void MISaveFile_Click(object sender, RoutedEventArgs e)
        {
            Stream myStream = null;
            //laat het venster zien en pak het (text)bestand
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.Filter = "Text Files|*.txt";
            saveFileDialog1.Title = "Select file location"; 
            //als binnen het venster knop 'OK' wordt ingedrukt
            //lees het geselecteerde bestand uit en sla de locatie van het menu op
            if (saveFileDialog1.ShowDialog() == true)
            {
                try
                {
                    if ((myStream = saveFileDialog1.OpenFile()) != null)
                    {
                        using (myStream)
                        {
                            StreamWriter streamWriter = new StreamWriter(myStream);
                            String inhoud = txtInput.Text;
                            streamWriter.Write(inhoud); // Schrijft de tekst naar het bestand.
                            streamWriter.Flush(); // Maakt de StreamWriter leeg
                            streamWriter.Close(); // Sluit de StreamWriter + het bestand
                            MessageBox.Show("Your modifications has been saved.", "Textfile modified");
                            txtInputChanged = false;
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error:\nThe selected file could not be read:\n" + ex.Message);
                }
            }
        }

        private void MICloseApp_Click(object sender, RoutedEventArgs e)
        {
            if (txtInputChanged == true)
            {
                MessageBoxResult result = MessageBox.Show("This current file has been modified, do you want to keep it?", "Textfile modified", MessageBoxButton.YesNoCancel);
                switch (result)
                {
                    case MessageBoxResult.Yes:
                        MISaveFile_Click(sender, e);
                        txtInputChanged = false;
                        break;
                    case MessageBoxResult.No:
                        Application.Current.Shutdown();
                        break;
                    case MessageBoxResult.Cancel:
                        break;
                }
            }
            else
            {
                Application.Current.Shutdown();
            }
        }

        public void TxtInput_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (txtInput.Text != "")
            {
                txtInputChanged = true;
            }
            else
            {
                txtInputChanged = false;
            }
        }

        private void MIOpenFile_Click(object sender, RoutedEventArgs e)
        {
            Stream myStream = null;
            //laat het venster zien en pak het (text)bestand
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            openFileDialog1.Filter = "Text Files|*.txt";
            openFileDialog1.Title = "Select a text file";
            //als binnen het venster knop 'OK' wordt ingedrukt
            //lees het geselecteerde bestand uit en sla de locatie van het menu op
            if (openFileDialog1.ShowDialog() == true)
            {
                try
                {
                    if ((myStream = openFileDialog1.OpenFile()) != null)
                    {
                        using (myStream)
                        {
                            StreamReader streamReader = new StreamReader(myStream);
                            txtInput.Text = streamReader.ReadToEnd();
                            streamReader.Dispose();
                            streamReader.Close();
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error:\nThe selected file could not be read:\n" + ex.Message);
                }
            }
        }
    }
}

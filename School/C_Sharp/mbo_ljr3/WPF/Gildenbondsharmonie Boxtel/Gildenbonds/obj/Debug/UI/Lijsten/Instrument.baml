   M S B A M L   `   `   `  ����F  BGildenbonds, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null?$clr-namespace:Gildenbondsharmonie.UIGildenbondsharmonie.UI  5      '    !Gildenbondsharmonie.UI.Instrument   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      6local$clr-namespace:Gildenbondsharmonie.UI     5      -   5          N�Name$  UIInstrument��5
       N� Title$ 
Instrument��5	      .��5      ��  �� Orientation$ Vertical=�6   .+�5   
   �� -   5         ��Name$ NaamSubvenster��5      $��30q�6,   $��Lijst Instrument��68   $��20(�6P    �� TextAlignment$ Center=�6^   $��Center=�6u   $��Center=�6�   6�   �� 5   
   $��Center=�6   $��18(�6-   .��6;   Filter6C   �� 5   
   
�������
�������$��1q�6@   $
��Auto��6T   $	��150��6b   ._�5      �� -   5         ��Name$ CheckboxFilter��5      .+�5      �� -   5         ��Name$ ckbFilterInstrumentType��5      $��Instrument type��6<   $
��Left=�6V   �� 5      -   5        $ ckbFilterAanschafprijs��5      $��Aanschafprijs��6;   $
��Left=�6S   �� 5      -   5        $ ckbFilterAanschafdatum��5      $��Aanschafdatum��6;   $
��Left=�6S   �� 5      -   5        $! ckbFilterAfschrijvingsdatum��5      $��Afschrijvingsdatum��6@   $
��Left=�6]   �� 5      -   5        $ ckbFilterVerzekerd��5      $��	Verzekerd��67   $
��Left=�6K   5      5      �� 5   
   -	   5         ��Name$ lvInstrument��5      $��40q�6)   $	��700��6�   $��Center=�6�   ��65   �� *Instrumenten+ �� SelectedItem 6Z   �� *SelectedInstrument+	 �� View	 5      �� 5      .P�5      �� $��
Instrument��6%   
 �� DisplayMemberBinding
 69   �� *
Instrument+6g   �� 5      $��Instrumenttype��6%   
 6=   �� *InstrumentType+6o   �� 5      $
��Merk��6%   
 63   �� *Merk+6[   �� 5      $��Serienummer��6%   
 6:   �� *SerieNummer+6i   �� 5       $��Aanschafprijs��6%   
 6<   �� *AanschafPrijs+6m   �� 5!      $��Aanschafdatum��6%   
 6<   �� *AanschafDatum+6m   �� 5"      $��Afschrijvingsdatum��6%   
 6A   �� *Afschrijvingsdatum+6w   �� 5#      $��Leverancier��6%   
 6:   �� *Leverancier+6i   �� 5$      $��	Verzekerd��6%   
 68   �� *	Verzekerd+6e   �� 5%      $��Verzekeringswaarde��6%   
 6A   �� *VerzekeringsWaarde+6w   5&      5(      5)      5*      
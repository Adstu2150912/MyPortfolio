<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login en registratieform</title>
     <script src="Scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
    <link href="ASPform.css" rel="stylesheet" type="text/css" />
    <script>
        $(document).ready(function () {
            $('header > h1').empty('*');
            $('header > h1').css('display', 'none');
            $('header > h1').append("Login- en registratieformulier").fadeIn(1000);
        });
    </script>
    <style type="text/css">
        .auto-style1 {
            width: 939px;
        }
        .auto-style6 {
            width: 285px;
        }
        .auto-style8 {
            height: 26px;
            width: 87px;
        }
        .auto-style9 {
            width: 327px;
            height: 29px;
        }
        .auto-style10 {
            height: 29px;
            width: 179px;
        }
        .auto-style11 {
            width: 327px;
            height: 34px;
        }
        .auto-style12 {
            height: 34px;
            width: 179px;
        }
        .auto-style17 {
            width: 327px;
        }
        .auto-style20 {
            width: 87px;
        }
        .auto-style29 {
            width: 179px;
        }
        .auto-style31 {
            width: 328px;
        }
        .auto-style32 {
            width: 309px;
        }
    </style>
</head>
<body>
     <header>
        <h1></h1>
    </header>
    <nav>
        <h3><a href="../../../../../../../../index.html">Portfolio website <br/> Adam Oubelkas</a></h3>
        <ul>
            <li>
                <a href="../../../../../../../webpaginas/Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
            </li>
            <li>
                <a href="../../../../../../../webpaginas/Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
            </li>
            <li>
                <a href="../../../../../../../webpaginas/Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
            </li>
            <li>
                <a href="../../../../../../../webpaginas/Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
            </li>
        </ul>
    </nav>
    <section>
        <div id="main">
            <div>
                <form id="form1" runat="server">
                    <div>
                    <asp:Label ID="lblTitel" runat="server" Text="
                    &lt;h1 id=&quot;h1Inloggen&quot;&gt;Inloggen bij Netwerk
                    &lt;/h1&gt;   
                    " ForeColor="Blue"></asp:Label>    
                        <asp:RadioButtonList ID="rblInloggen" runat="server" AutoPostBack="True" RepeatDirection="Horizontal" Width="331px">
                        <asp:ListItem Value="1">Inloggen</asp:ListItem>
                        <asp:ListItem Value="2">Registreren</asp:ListItem>
                        </asp:RadioButtonList>
                        <br />
                        <br />
                    <asp:Panel ID="pnlOpdracht1" runat="server" Visible="False">
                        <table class="auto-style1" border="0">
                            <tr>
                                <td class="auto-style31">Nickname</td>
                                <td class="auto-style32">
                                    <asp:TextBox ID="txtBijnaam" runat="server" Width="200px"></asp:TextBox>
                                </td>
                                <td>
                                    <asp:RequiredFieldValidator ID="rfvBijnaam" runat="server" ControlToValidate="txtBijnaam" Display="Dynamic" ErrorMessage="Verplicht veld"></asp:RequiredFieldValidator>
                                </td>
                            </tr>
                            <tr>
                                <td class="auto-style31">Wachtwoord</td>
                                <td class="auto-style32">
                                    <asp:TextBox ID="txtWachtwoordLogin" runat="server" TextMode="Password" Width="200px"></asp:TextBox>
                                </td>
                                <td>
                                    <asp:RequiredFieldValidator ID="rfvWachtwoordLogin" runat="server" ControlToValidate="txtWachtwoordLogin" Display="Dynamic" ErrorMessage="Verplicht veld"></asp:RequiredFieldValidator>
                                </td>
                            </tr>
                            <tr>
                                <td class="auto-style31">&nbsp;</td>
                                <td class="auto-style32">
                                    <asp:Button ID="btnLogin" runat="server" Text="Log in" OnClick="btnLogin_Click" Width="100px" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <asp:Label ID="lblMelding" runat="server"></asp:Label>
                                </td>
                            </tr>
                        </table>
                    </asp:Panel>
                        <asp:Panel ID="pnlOpdracht2" runat="server" Visible="False">
                            <table class="auto-style1">
                                <tr>
                                    <td class="auto-style17">Voornaam *</td>
                                    <td class="auto-style29">
                                        <asp:TextBox ID="txtVoornaam" runat="server" Width="193px"></asp:TextBox>
                                    </td>
                                    <td>
                                        <asp:RegularExpressionValidator ID="revVoornaam" runat="server" ControlToValidate="txtVoornaam" Display="Dynamic" ErrorMessage="Voornaam is ongeldig!" ValidationExpression="^[a-zA-Z&quot;-'\s]{2,20}$"></asp:RegularExpressionValidator>
                                        &nbsp;<br/>
                                        <asp:RequiredFieldValidator ID="rfvVoornaam0" runat="server" ControlToValidate="txtVoornaam" Display="Dynamic" ErrorMessage="Dit is verplicht!"></asp:RequiredFieldValidator>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Tussenvoegsel</td>
                                    <td class="auto-style29">
                                        <asp:TextBox ID="txtTussenvoegsel" runat="server" Width="192px"></asp:TextBox>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style11">Achternaam *</td>
                                    <td class="auto-style12">
                                        <asp:TextBox ID="txtAchternaam" runat="server" Width="239px"></asp:TextBox>                       
                                    </td>
                                    <td>
                                        <asp:RequiredFieldValidator ID="rfvAchternaam" runat="server" ControlToValidate="txtAchternaam" Display="Dynamic" ErrorMessage="Dit is verplicht!"></asp:RequiredFieldValidator>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Postcode</td>
                                    <td class="auto-style29">
                                        <asp:TextBox ID="txtPostcode" runat="server" Width="192px"></asp:TextBox>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Geslacht *</td>
                                    <td class="auto-style29">
                                        <asp:RadioButtonList ID="rbGeslacht" runat="server" AutoPostBack="True" RepeatDirection="Horizontal" Width="299px">
                                            <asp:ListItem>Man</asp:ListItem>
                                            <asp:ListItem>Vrouw</asp:ListItem>
                                        </asp:RadioButtonList>                  
                                    </td>
                                    <td> <asp:RequiredFieldValidator ID="rfvGeslacht" runat="server" ControlToValidate="rbGeslacht" Display="Dynamic" ErrorMessage="Vul uw geslacht in!"></asp:RequiredFieldValidator></td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Geboortedatum</td>
                                    <td class="auto-style29">
                                        <asp:Calendar ID="cldGeboortedatum" runat="server" BackColor="#3F3F3F" BorderColor="White" CssClass="kalender" FirstDayOfWeek="Monday" ForeColor="White">
                                            <DayHeaderStyle BackColor="#CCCCCC" />
                                        </asp:Calendar>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">E-mailadres *</td>
                                    <td class="auto-style29">
                                        <asp:TextBox ID="txtEmailadres" runat="server" Width="267px"></asp:TextBox>
                                    </td>
                                    <td><asp:RequiredFieldValidator ID="rfvEmailadres" runat="server" ControlToValidate="txtEmailadres" Display="Dynamic" ErrorMessage="Dit is verplicht!"></asp:RequiredFieldValidator>
                                        <br/>
                                        <asp:RegularExpressionValidator ID="revEmailadres0" runat="server" ControlToValidate="txtEmailadres" Display="Dynamic" ErrorMessage="E-mailadres is ongeldig!" ValidationExpression="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|&quot;(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*&quot;)@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])"></asp:RegularExpressionValidator>
                                </td>
                                </tr>
                                <tr>
                                    <td class="auto-style9">Wachtwoord *</td>
                                    <td class="auto-style10">
                                        <asp:TextBox ID="txtWachtwoordRegistratie" runat="server" TextMode="Password" Width="267px"></asp:TextBox>                                         
                                    </td>
                                    <td>&nbsp;<br/> <asp:RequiredFieldValidator ID="rfvWachtwoordRegistratie" runat="server" Display="Dynamic" ErrorMessage="Dit is verplicht!" ControlToValidate="txtWachtwoordRegistratie"></asp:RequiredFieldValidator></td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Herhaal wachtwoord</td>
                                    <td class="auto-style29">
                                        <asp:TextBox ID="txtHerhaalWachtwoord" runat="server" TextMode="Password" Width="265px"></asp:TextBox>                                 
                                    </td>
                                    <td><asp:CompareValidator ID="cvHerhaalWachtwoord" runat="server" ControlToCompare="txtWachtwoordRegistratie" ControlToValidate="txtHerhaalWachtwoord" Display="Dynamic" ErrorMessage="Wachtwoorden komen niet overeen!"></asp:CompareValidator></td>
                                </tr>
                                <tr>
                                    <td class="auto-style17">Voorwaarden</td>
                                    <td class="auto-style20" colspan="2">
                                        <asp:CheckBox ID="cbVoorwaarden" runat="server" OnCheckedChanged="cbVoorwaarden_CheckedChanged" Text="Ik accepteer de voorwaarden" AutoPostBack="True" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style8" colspan="3">
                                        <asp:Button ID="btnAccountMaken" runat="server" Enabled="False" OnClick="btnAccountMaken_Click" Text="Account aanmaken" Width="288px" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="auto-style6" colspan="3">
                                        <asp:Label ID="lblMeldingOpdracht2" runat="server"></asp:Label>
                                    </td>
                                </tr>
                            </table>
                    </asp:Panel>
                </div>
            </form>
        </div>
    </div>
</section>
<footer>
    <p>&copy 2024 Adam Oubelkas <br/> Gemaakt in HTML5, CSS3, PHP 7.1 en JQuery 3.2.0.</p>
</footer>
</body>
</html>

<%@ Page Title="" Language="C#" MasterPageFile="MasterPage.master" AutoEventWireup="true" CodeFile="Records.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h2>Records</h2>
    <br />
    Wat is de <asp:DropDownList ID="ddlAchtbaan" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged">
        <asp:ListItem Selected="True">selecteer</asp:ListItem>
        <asp:ListItem>hoogste</asp:ListItem>
        <asp:ListItem>snelste</asp:ListItem>
        <asp:ListItem>langste</asp:ListItem>
    </asp:DropDownList> achtbaan?
    <br />
    <asp:Label ID="lblAchtbaan" runat="server" Text=""></asp:Label>

</asp:Content>


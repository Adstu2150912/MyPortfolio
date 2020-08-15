<%@ Page Title="" Language="C#" MasterPageFile="MasterPage.master" AutoEventWireup="true" CodeFile="Overzicht.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <h2>Overzicht</h2>
    <br />
    <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="pretparkId" DataSourceID="SqlDataSource1" EmptyDataText="There are no data records to display." AllowPaging="True" AllowSorting="True">
        <Columns>
            <asp:CommandField ShowSelectButton="True" />
            <asp:BoundField DataField="naam" HeaderText="Pretpark" SortExpression="naam" />
            <asp:BoundField DataField="land" HeaderText="Land" SortExpression="land" />
            <asp:BoundField DataField="plaats" HeaderText="Plaats" SortExpression="plaats" />
        </Columns>
    </asp:GridView>
    <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:achtbanenConnectionString %>" DeleteCommand="DELETE FROM [pretpark] WHERE [pretparkId] = @pretparkId" InsertCommand="INSERT INTO [pretpark] ([naam], [land], [plaats]) VALUES (@naam, @land, @plaats)" ProviderName="<%$ ConnectionStrings:achtbanenConnectionString.ProviderName %>" SelectCommand="SELECT [pretparkId], [naam], [land], [plaats] FROM [pretpark]" UpdateCommand="UPDATE [pretpark] SET [naam] = @naam, [land] = @land, [plaats] = @plaats WHERE [pretparkId] = @pretparkId">
        <DeleteParameters>
            <asp:Parameter Name="pretparkId" Type="Int32" />
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="naam" Type="String" />
            <asp:Parameter Name="land" Type="String" />
            <asp:Parameter Name="plaats" Type="String" />
        </InsertParameters>
        <UpdateParameters>
            <asp:Parameter Name="naam" Type="String" />
            <asp:Parameter Name="land" Type="String" />
            <asp:Parameter Name="plaats" Type="String" />
            <asp:Parameter Name="pretparkId" Type="Int32" />
        </UpdateParameters>
    </asp:SqlDataSource>


    <asp:DetailsView ID="DetailsView1" runat="server" AllowPaging="True" AutoGenerateRows="False" DataKeyNames="achtbaanId" DataSourceID="SqlDataSource3" Height="50px" Width="125px">
        <Fields>
            <asp:BoundField DataField="naam" HeaderText="Naam attractie" SortExpression="naam" />
            <asp:BoundField DataField="lengte" HeaderText="lengte" SortExpression="lengte" />
            <asp:BoundField DataField="hoogte" HeaderText="hoogte" SortExpression="hoogte" />
            <asp:BoundField DataField="inversies" HeaderText="inversies" SortExpression="inversies" />
            <asp:BoundField DataField="snelheid" HeaderText="snelheid" SortExpression="snelheid" />
        </Fields>
    </asp:DetailsView>
    <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:achtbanenConnectionString %>" SelectCommand="SELECT * FROM [achtbaan] WHERE ([achtbaanId] = @achtbaanId)">
        <SelectParameters>
            <asp:ControlParameter ControlID="GridView1" Name="achtbaanId" PropertyName="SelectedValue" Type="Int32" />
        </SelectParameters>
    </asp:SqlDataSource>
    <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:achtbanenConnectionString %>" DeleteCommand="DELETE FROM [pretpark] WHERE [pretparkId] = @pretparkId" InsertCommand="INSERT INTO [pretpark] ([naam], [land], [plaats]) VALUES (@naam, @land, @plaats)" SelectCommand="SELECT * FROM [pretpark] WHERE ([pretparkId] = @pretparkId)" UpdateCommand="UPDATE [pretpark] SET [naam] = @naam, [land] = @land, [plaats] = @plaats WHERE [pretparkId] = @pretparkId">
        <DeleteParameters>
            <asp:Parameter Name="pretparkId" Type="Int32" />
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="naam" Type="String" />
            <asp:Parameter Name="land" Type="String" />
            <asp:Parameter Name="plaats" Type="String" />
        </InsertParameters>
        <SelectParameters>
            <asp:ControlParameter ControlID="GridView1" Name="pretparkId" PropertyName="SelectedValue" Type="Int32" />
        </SelectParameters>
        <UpdateParameters>
            <asp:Parameter Name="naam" Type="String" />
            <asp:Parameter Name="land" Type="String" />
            <asp:Parameter Name="plaats" Type="String" />
            <asp:Parameter Name="pretparkId" Type="Int32" />
        </UpdateParameters>
    </asp:SqlDataSource>


</asp:Content>


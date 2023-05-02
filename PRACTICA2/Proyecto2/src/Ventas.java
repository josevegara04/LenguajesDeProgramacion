public class Ventas 
{
    private String orderNumber;
    private int quantityOrdered;
    private double price;
    private String orderLineNumber;
    private String sales;
    private String orderDate;
    private String orderStatus;
    private String QTR_ID;
    private String month_ID;
    private String year_ID;
    private String productLine;
    private String MSRP;
    private String productCode;
    private String costumerName;
    private String phone;
    private String adress1;
    private String adress2;
    private String city;
    private String state;
    private String postalCode;
    private String contry;
    private String territory;
    private String contactLastName;
    private String contactFirstName;
    private String dealSize;

    
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(String orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getQTR_ID() {
        return QTR_ID;
    }

    public void setQTR_ID(String qTR_ID) {
        QTR_ID = qTR_ID;
    }

    public String getMonth_ID() {
        return month_ID;
    }

    public void setMonth_ID(String month_ID) {
        this.month_ID = month_ID;
    }

    public String getYear_ID() {
        return year_ID;
    }

    public void setYear_ID(String year_ID) {
        this.year_ID = year_ID;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getMSRP() {
        return MSRP;
    }

    public void setMSRP(String mSRP) {
        MSRP = mSRP;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getDealSize() {
        return dealSize;
    }

    public void setDealSize(String dealSize) {
        this.dealSize = dealSize;
    }

    Ventas ()
    {

    }

    Ventas (String orderNumber,
            int quantityOrdered,
            double price,
            String orderLineNumber,
            String sales,
            String orderDate,
            String orderStatus,
            String QTR_ID,
            String month_ID,
            String year_ID,
            String productLine,
            String MSRP,
            String productCode,
            String costumerName,
            String phone,
            String adress1,
            String adress2,
            String city,
            String state,
            String postalCode,
            String contry,
            String territory,
            String contactFirstName,
            String contactLastName,
            String dealSize)
    {
        this.orderNumber = orderNumber;
        this.quantityOrdered = quantityOrdered;
        this.price = price;
        this.orderLineNumber = orderLineNumber;
        this.sales = sales;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.QTR_ID = QTR_ID;
        this.month_ID = month_ID;
        this.year_ID = year_ID;
        this.productLine = productLine;
        this.MSRP = MSRP;
        this.productCode = productCode;
        this.costumerName = costumerName;
        this.phone = phone;
        this.adress1 = adress1;
        this.adress2 = adress2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.contry = contry;
        this.territory = territory;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.dealSize = dealSize;
    }
}
package resources;

// Enum is the special class in Java which have collection of constants and methods
public enum ApiResources {


    CreateOrder("/api/ecom/order/create-order"),
    Login("/api/ecom/auth/login"),
    AddProduct("/api/ecom/product/add-product");
    private String resource;

    ApiResources(String s) {

        resource = s;
    }

    public String getResource() {

        return resource;
    }
}

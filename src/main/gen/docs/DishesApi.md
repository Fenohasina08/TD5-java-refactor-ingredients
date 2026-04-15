# DishesApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllDishes**](DishesApi.md#getAllDishes) | **GET** /dishes | Retrieve all dishes with their ingredients |
| [**updateDishIngredients**](DishesApi.md#updateDishIngredients) | **PUT** /dishes/{id}/ingredients | Replace the ingredient list of a dish (attach/detach) |


<a id="getAllDishes"></a>
# **getAllDishes**
> List&lt;Dish&gt; getAllDishes()

Retrieve all dishes with their ingredients

Returns a list of all dishes. Each dish includes its identifier, name, selling price, and the full list of ingredients (each ingredient contains id, name, category, and price).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DishesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DishesApi apiInstance = new DishesApi(defaultClient);
    try {
      List<Dish> result = apiInstance.getAllDishes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DishesApi#getAllDishes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Dish&gt;**](Dish.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation – the list of dishes is returned. |  -  |
| **500** | Internal server error. |  -  |

<a id="updateDishIngredients"></a>
# **updateDishIngredients**
> Dish updateDishIngredients(id, ingredientRef)

Replace the ingredient list of a dish (attach/detach)

Completely replaces the set of ingredients associated with a dish. - The request body must be a non‑empty array of objects containing only the &#x60;id&#x60; field. - Any ingredient ID that does not exist in the database is silently ignored. - If the dish is not found, a 404 with a plain text message is returned. - On success, the updated dish (including its new ingredient list) is returned. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DishesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    DishesApi apiInstance = new DishesApi(defaultClient);
    Integer id = 1; // Integer | Unique identifier of the dish.
    List<IngredientRef> ingredientRef = Arrays.asList(); // List<IngredientRef> | List of ingredient identifiers to associate with the dish.
    try {
      Dish result = apiInstance.updateDishIngredients(id, ingredientRef);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DishesApi#updateDishIngredients");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Unique identifier of the dish. | |
| **ingredientRef** | [**List&lt;IngredientRef&gt;**](IngredientRef.md)| List of ingredient identifiers to associate with the dish. | |

### Return type

[**Dish**](Dish.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Dish successfully updated – the updated dish object is returned. |  -  |
| **400** | Empty or missing request body. |  -  |
| **404** | Dish not found. |  -  |
| **500** | Internal server error. |  -  |


# IngredientsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllIngredients**](IngredientsApi.md#getAllIngredients) | **GET** /ingredients | Retrieve all ingredients |
| [**getIngredientById**](IngredientsApi.md#getIngredientById) | **GET** /ingredients/{id} | Retrieve an ingredient by its ID |
| [**getIngredientStock**](IngredientsApi.md#getIngredientStock) | **GET** /ingredients/{id}/stock | Retrieve the stock value of an ingredient at a given time |


<a id="getAllIngredients"></a>
# **getAllIngredients**
> List&lt;Ingredient&gt; getAllIngredients()

Retrieve all ingredients

Returns a list of all ingredients stored in the database, each containing its unique identifier, name, category, and unit price.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    try {
      List<Ingredient> result = apiInstance.getAllIngredients();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#getAllIngredients");
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

[**List&lt;Ingredient&gt;**](Ingredient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation – the list of ingredients is returned. |  -  |
| **500** | Internal server error. |  -  |

<a id="getIngredientById"></a>
# **getIngredientById**
> Ingredient getIngredientById(id)

Retrieve an ingredient by its ID

Fetches the ingredient that matches the given identifier. If no ingredient is found, a 404 status code is returned with a plain text error message.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    Integer id = 1; // Integer | Unique identifier of the ingredient.
    try {
      Ingredient result = apiInstance.getIngredientById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#getIngredientById");
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
| **id** | **Integer**| Unique identifier of the ingredient. | |

### Return type

[**Ingredient**](Ingredient.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ingredient found – the corresponding JSON object is returned. |  -  |
| **404** | Ingredient not found – the response contains a plain text message as required by the specification. |  -  |
| **500** | Internal server error. |  -  |

<a id="getIngredientStock"></a>
# **getIngredientStock**
> StockValue getIngredientStock(id, at, unit)

Retrieve the stock value of an ingredient at a given time

Calculates the stock quantity of the specified ingredient at a specific moment (ISO 8601 timestamp), expressed in the requested unit (PCS, KG, or L). Both query parameters &#x60;at&#x60; and &#x60;unit&#x60; are mandatory. If any of them is missing, a 400 error is returned. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.IngredientsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    IngredientsApi apiInstance = new IngredientsApi(defaultClient);
    Integer id = 1; // Integer | Identifier of the ingredient.
    OffsetDateTime at = OffsetDateTime.parse("2024-01-06T12:00:00Z"); // OffsetDateTime | The point in time (ISO 8601 format) for which the stock is calculated.
    String unit = "PCS"; // String | The desired unit of measurement (PCS = pieces, KG = kilograms, L = liters).
    try {
      StockValue result = apiInstance.getIngredientStock(id, at, unit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IngredientsApi#getIngredientStock");
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
| **id** | **Integer**| Identifier of the ingredient. | |
| **at** | **OffsetDateTime**| The point in time (ISO 8601 format) for which the stock is calculated. | |
| **unit** | **String**| The desired unit of measurement (PCS &#x3D; pieces, KG &#x3D; kilograms, L &#x3D; liters). | [enum: PCS, KG, L] |

### Return type

[**StockValue**](StockValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Stock value successfully computed. |  -  |
| **400** | Missing mandatory query parameter (&#x60;at&#x60; or &#x60;unit&#x60;). |  -  |
| **404** | Ingredient not found. |  -  |
| **500** | Internal server error. |  -  |


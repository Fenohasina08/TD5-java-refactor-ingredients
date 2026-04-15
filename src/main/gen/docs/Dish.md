

# Dish

A dish composed of ingredients, with its selling price.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | Unique identifier of the dish. |  |
|**name** | **String** | Name of the dish. |  |
|**price** | **Double** | Selling price of the dish (may be null if not set). |  |
|**dishType** | [**DishTypeEnum**](#DishTypeEnum) | Type of dish (optional, not required by the assignment). |  [optional] |
|**ingredients** | [**List&lt;Ingredient&gt;**](Ingredient.md) | List of ingredients that compose the dish. |  |



## Enum: DishTypeEnum

| Name | Value |
|---- | -----|
| STARTER | &quot;STARTER&quot; |
| MAIN | &quot;MAIN&quot; |
| DESSERT | &quot;DESSERT&quot; |




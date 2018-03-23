
var app = angular.module('myapp', ['ngRoute', 'angular-storage']);
app.config(function ($routeProvider, $locationProvider) {

    $routeProvider
            .when("/", {
                templateUrl: '/home.html'
            }).when("/registration", {
        templateUrl: "/registration.html",
        controller: "registrationController"
    }).when("/login", {
        templateUrl: "/login.html",
        controller: "loginController"
    }).when("/products", {
        templateUrl: "/products.html",
        controller: "productController"
    }).when("/customerProducts", {
        templateUrl: "/customerProducts.html",
        controller: "productController"
    }).when("/admin", {
        templateUrl: "/admin.html",
        controller: "adminController"
    }).when("/supplier", {
        templateUrl: "/supplier.html",
        controller: "adminController"
    }).when("/driver", {
        templateUrl: "/driver.html",
        controller: "adminController"
    }).when("/contactUs", {
        templateUrl: "/contactUs.html",
        controller: "contactUsController"
    }).when("/addProduct", {
        templateUrl: "/addProduct.html",
        controller: "productController"
    }).when("/addPromotions", {
        templateUrl: "/addPromotions.html",
        controller: "promotionsController"
    }).when("/updateProd", {
        templateUrl: "/updateProd.html",
        controller: "productController"
//    }).when("/cart", {
//        templateUrl: "/cart.html",
//        controller: "productController"
    }).when("/adminProducts", {
        templateUrl: "/adminProducts.html",
        controller: "productController"
    }).when("/promotions", {
        templateUrl: "/promotions.html",
        controller: "promotionsController"
    }).when("/requestStock", {
        templateUrl: "/requestStock.html",
        controller: "stockController"
    }).when("/replyRequest", {
        templateUrl: "/replyRequest.html",
        controller: "stockController"
    }).when("/updateRequest", {
        templateUrl: "/updateRequest.html",
        controller: "stockController"
    }).when("/updateStatus", {
        templateUrl: "/updateStatus.html",
        controller: "productController"
    }).when("/adminOrders", {
        templateUrl: "/adminOrders.html",
        controller: "adminController"
    }).when("/supplyProducts", {
        templateUrl: "/supplyProducts.html",
        controller: "stockController"
    }).when("/customersList", {
        templateUrl: "/customersList.html",
        controller: "adminController"
    }).when("/customerPromotions", {
        templateUrl: "/customerPromotions.html",
        controller: "promotionsController"
    }).when("/addProd", {
        templateUrl: "/addProd.html",
        controller: "stockController"
    }).when("/adminRequest", {
        templateUrl: "/adminRequest.html",
        controller: "stockController"
    }).when("/supplyRespond", {
        templateUrl: "/supplyRespond.html",
        controller: "stockController"
    }).when("/checkout", {
        templateUrl: "/checkout.html",
        controller: "productController"

    }).otherwise({
        redirectTo: ("/")
    });

    $locationProvider.html5Mode(false);


});

app.controller('registrationController', function ($scope, $http, $location, $rootScope) {

    $scope.registration = function () {
        var templateUrl = "/registration";
        var customer = $scope.customer;
        $http.post(templateUrl, customer).then(successCallback, errorCallback);
        function successCallback(response) {
            $rootScope.customer = customer;
            $location.url("/login");
            alert(customer.firstname + " " + "You have Successfully Registered, Click OK to login");
        }
        function errorCallback(response) {
            $location.url("/registration");
            alert(response.data.status);
        }
    };


});
app.controller('loginController', function ($http, $scope, $location, store, $rootScope) {
    $scope.login = function () {
        $http({
            url: '/login/user',
            method: 'GET',
            params: {username: $scope.username, password: $scope.password}
        }).then(successCallback, errorCallback);
        function successCallback(respose) {
            var customer = respose.data;
            localStorage.setItem("customer", JSON.stringify(customer.id));


            if (customer.username === "Thato") {
                alert("Welcome Admin!!!");
                ;
                $location.url('/admin');
            } else {
                if ($scope.username === "supplier") {
                    alert("Successfully Logged In as a Supplier");
                    $location.url('/supplier');
                } else {
                    if ($scope.username === "driver") {
                        alert("Successfully Logged In as a driver");
                        $location.url('/driver');
                    } else {
                        if ($scope.username === customer.username) {
                            alert("Successfully Logged In");
                            $location.url('/products');
                        } else {
                            alert("Invalid Credentials,Please try again");
                            $location.url('/login');
                        }
                    }
                }
            }
        }
        ;
        function errorCallback(response) {
            console.log(response);
            alert("Invalid Credentials,Please try again");
            $location.url('/login');
        }
        ;
    };



});

app.controller('adminController', function ($http, $scope) {
    $http.get("/customers/all").then(function (response) {
        $scope.customers = response.data;
    });

    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;


    });

    $http.get("/promotions/all").then(function (response) {
        $scope.promotions = response.data;


    });

    $http.get("/stock/all").then(function (response) {
        $scope.stock = response.data;


    });

    $http.get("/customerOrder/all").then(function (response) {


        $scope.customerOrder = response.data;

    });


    $scope.updateProd = function (newProdData) {

        $http.post("/addProduct", newProdData).then(function (map) {
            alert("Product Successfully Updated");

        });
    };
    //Delete
    $scope.DeleteProduct = function (prod)
    {
        alert('delete');
        var name = prod.name;
        console.log(name);
        $http.get('/DeleteProduct/' + name).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {

                alert("Product has been Deleted");
                location.reload(true);
            } else {

                alert("Product Not Deleted..!!!");
                location.reload(true);
            }
        });
    }
});
app.controller('logoutController', function ($location, $session) {
    $session.clear();
    $location.url("/login");
});





app.controller('productController', function ($http, $scope, $location, $rootScope, $filter) {

    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/addProduct';


    $scope.saveProd = function () {
        var file = document.getElementById('filePickerImage');
        var iname = file.files.item(0).name;
        $http.post(url, {
            name: $scope.name,
            description: $scope.description,
            price: $scope.price,
            category: $scope.category,
            prod_quantity: $scope.prod_quantity,
            batchQty: $scope.batchQty,
            image: iname


        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Product Added Successfully");
            console.log(response.data);
            $location.url('/admin');
        }
        function errorCallback(response) {
            console.log(response);
            alert("failed to add Product");
        }
        ;
    };




    /**Retrieving Products from the Database**/
    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;
        console.log(response.data.image);
    });



    $scope.cart = [];
    $scope.total = 0;
    var quantity = $scope.quantity;
    $scope.addToCart = function (prod) {
        if ($scope.cart.length === 0) {
            prod.quantity = 1;
            $scope.cart.push(prod);

//            console.log($scope.cart);
        } else {
            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].product_id === prod.product_id) {
                    alert("Product Already Added Into Your Cart!!!");
                    // $scope.total += parseFloat(prod.price);
                    break;
                } else {
                    //alert("not found in cart list");
                    $scope.cart.push(prod);
                    prod.quantity = 1;
                    break;
                }
            }
        }



        $scope.total += parseFloat(prod.price);

        localStorage.setItem("quantity", JSON.stringify(prod.quantity));
        localStorage.setItem("total", JSON.stringify($scope.total));
//        console.log( localStorage.getItem("cartData"));

    };


    $scope.removeProdCart = function (prod) {
        if (prod.quantity > 1) {
            prod.quantity -= 1;
            localStorage.setItem("quantity", JSON.stringify(prod.quantity));
        } else if (prod.quantity === 1) {
            var index = $scope.cart.indexOf(prod);
            $scope.cart.splice(index, 1);
        }
        $scope.total -= parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));


    };
    $scope.incrementQuantity = function (prod) {
        var originalQty = prod.prod_quantity;
//        var originalQty = prod.batchQty

        prod.quantity += 1;
        $scope.total += parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
        localStorage.setItem("quantity", JSON.stringify(prod.quantity));

        if (originalQty < prod.quantity) {
            alert("The selected quantity exceeds stock");
        } else {
            var newQty = originalQty - prod.quantity;
//            var newQty = originalQty - prod.batchQty;

            prod.prod_quantity = newQty;
//             prod.batchQty = newQty;

            $http.post("/updateProduct", prod).then(function (map) {
                console.log(response);

            });
        }
        ;
    }




    $scope.goToCheckoutPage = function () {
        $location.url('/checkout');
    };


    $scope.placeOrder = function () {

        var orderData = {
            'custId': localStorage.getItem("customer"),
            'orderId': localStorage.getItem("Order Id"),
            'price': localStorage.getItem("total"),
//            'productCopy': localStorage.getItem("cartData"),
            'bank_id': localStorage.getItem("BankDetails"),
            'quantity': localStorage.getItem("quantity"),
            'status': 'Order pending...',
            'orderedDate': $filter('date')(new Date(), 'yyyy-mm-dd')

        };

        $scope.updateStatus = new function (orderId, status) {


        }
//        console.log(orderData);

        $http({
            url: '/placeOrder',
            method: "POST",
            data: orderData,
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Congratulations ,Your Order has been placed Successfully ");
            $rootScope.order = response.data;
        }
        function errorCallback(response) {
            alert("failed");
            console.log(response.data);
        }
        ;

    };


    $scope.makePayment = function () {
        $http({
            url: '/pay',
            method: 'GET',
            params: {
                'bank_id': $scope.bank_details.bank_id,
                'accNo': $scope.bank_details.accNo,
                'pin': $scope.bank_details.pin
            }
        }).then(successCallBack, errorCallBack);
        function successCallBack(response) {
            if ($scope.bank_id === bank_id) {
                localStorage.setItem("bank_details", JSON.stringify($scope.bank.id));
                console.log(localStorage.getItem("bank_details"));
            }
            ;
        }
        ;
        function errorCallBack() {

        }
        ;
    };

    //Update Product
    $scope.redirectToUpdate = function (prod) {

        $rootScope.editProduct = prod;
        $location.url('/updateProd');
    };

    $scope.updateProduct = function (newProdData) {

        $http.post("/updateProduct", newProdData).then(function (map) {
            alert("Product Successfully Updated");
            $location.url('/adminProducts');
        });
    };



    //Update status
    $scope.redirectToUpdateStatus = function (order) {
        alert(JSON.stringify(order));
        $rootScope.editStatus = order;
        $location.url('/updateStatus');
    };

    $scope.updateRequest = function (newOrderData) {

        $http.post("/updateStatus", newOrderData).then(function (map) {
            alert("Product Successfully Updated");

        });
    };

    //Delete
    $scope.DeleteProduct = function (prod)
    {
        alert('delete');
        var name = prod.name;
        console.log(name);
        $http.get('/DeleteProduct/' + name).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {

                alert("Product has been Deleted");
                location.reload(true);
            } else {

                alert("Product Not Deleted..!!!");
                location.reload(true);
            }
        });
    };
    $scope.refresh = function () {
        location.reload(true);
    };

    //update Product Quantity
    $scope.updateQuantity = function (prod) {

        var prod_quantity = prod.prod_quantity;
//        var batchQty = prod.batchQty + prod_quantity;

//var prod_quantity = prod.prod_quantity + 5;
prod.prod_quantity = prod_quantity;
var prod_quantity = prod.batchQty + 1;

        prod.batchQty = prod_quantity;

        $http.post("/updateProduct", prod).then(function (response) {
            console.log(response.data);
            alert("Quantity Successfully Updated");
        });
    }

});
app.controller('supplierController', function ($http, $scope, $location, $rootScope, $filter) {
    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;


    });

});
app.controller('promotionsController', function ($http, $scope, $location, $rootScope, $filter) {

    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/addPromotions';


    $scope.savePromo = function () {
        var file = document.getElementById('filePickerImage');
        var iname = file.files.item(0).name;
        $http.post(url, {
            name: $scope.name,
            description: $scope.description,
            price: $scope.price,
            category: $scope.category,
            image: iname


        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Promotion Added Successfully");
            console.log(response.data);
            $location.url('/admin');
        }
        function errorCallback(response) {
            console.log(response);
            alert("Promotion to add Product");
        }
        ;
    };


    /**Retrieving Products from the Database**/
    $http.get("/promotions/all").then(function (response) {
        $scope.promotions = response.data;
        console.log(response.data.image);
//            localStorage.setItem("product", JSON.stringify($scope.products));
    });
    $scope.cart = [];
    $scope.total = 0;
    var quantity = $scope.quantity;
    $scope.addToCart = function (promo) {
        if ($scope.cart.length === 0) {
            promo.quantity = 1;
            $scope.cart.push(promo);

//            console.log($scope.cart);
        } else {
            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].promo_id === promo.promo_id) {
                    alert("Product Already Added Into Your Cart!!!");
                    break;
                } else {
                    //alert("not found in cart list");
                    $scope.cart.push(promo);
                    promo.quantity = 1;
                    break;
                }
            }
        }



        $scope.total += parseFloat(promo.price);

        localStorage.setItem("quantity", JSON.stringify(promo.quantity));
        localStorage.setItem("total", JSON.stringify($scope.total));
//        console.log( localStorage.getItem("cartData"));

    };


    $scope.removeProdCart = function (promo) {
        if (promo.quantity > 1) {
            promo.quantity -= 1;
            localStorage.setItem("quantity", JSON.stringify(promo.quantity));
        } else if (promo.quantity === 1) {
            var index = $scope.cart.indexOf(promo);
            $scope.cart.splice(index, 1);
        }
        $scope.total -= parseFloat(promo.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
    };
    $scope.incrementQuantity = function (promo) {
        promo.quantity += 1;
        $scope.total += parseFloat(promo.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
        localStorage.setItem("quantity", JSON.stringify(promo.quantity));
    };

    $scope.goToCheckoutPage = function () {
        $location.url('/checkout');
    };


    $scope.placeOrder = function () {

        var orderData = {
            'custId': localStorage.getItem("customer"),
            'orderId': localStorage.getItem("Order Id"),
            'price': localStorage.getItem("total"),
//            'productCopy': localStorage.getItem("cartData"),
            'bankDetailId': localStorage.getItem("bankDetail"),
            'quantity': localStorage.getItem("quantity"),
            'status': 'Order pending...',
            'orderedDate': $filter('date')(new Date(), 'yyyy-mm-dd')

        };
//        console.log(orderData);

        $http({
            url: '/placeOrder',
            method: "POST",
            data: orderData,
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Congratulations ,Your Order has been placed Successfully ");
            $rootScope.order = response.data;
        }
        function errorCallback(response) {
            alert("failed");
            console.log(response.data);
        }
        ;

    };


    $scope.makePayment = function () {
        $http({
            url: '/pay',
            method: 'GET',
            params: {
                'bank_id': $scope.bank.bank_id,
                'accNo': $scope.bank.accNo,
                'pin': $scope.bank.pin
            }
        }).then(successCallBack, errorCallBack);
        function successCallBack(response) {
            if ($scope.bank_id === bank_id) {
                localStorage.setItem("bankdetails", JSON.stringify($scope.bank.id));
                console.log(localStorage.getItem("bankdetails"));
            }
            ;
        }
        ;
        function errorCallBack() {

        }
        ;

    };
    //Delete
    $scope.DeletePromotions = function (promo)
    {
        alert('delete');
        var name = promo.name;
        console.log(name);
        $http.get('/DeletePromotions/' + name).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {

                alert("Promotion has been Deleted");
                location.reload(true);
            } else {

                alert("Promotion Not Deleted..!!!");
                location.reload(true);
            }
        });
    };
    $scope.refresh = function () {
        location.reload(true);
    };


});





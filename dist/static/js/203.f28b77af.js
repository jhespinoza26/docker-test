(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[203],{1405:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.r(__webpack_exports__);(function(module){var react__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__(0);var react__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);var Api__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__(127);function _typeof(e){"@babel/helpers - typeof";return _typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},_typeof(e)}(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;e&&e(module)})();function _classCallCheck(e,t){if(!(e instanceof t)){throw new TypeError("Cannot call a class as a function")}}function _defineProperties(e,t){for(var r=0;r<t.length;r++){var _=t[r];_.enumerable=_.enumerable||false;_.configurable=true;if("value"in _)_.writable=true;Object.defineProperty(e,_.key,_)}}function _createClass(e,t,r){if(t)_defineProperties(e.prototype,t);if(r)_defineProperties(e,r);Object.defineProperty(e,"prototype",{writable:false});return e}function _inherits(e,t){if(typeof t!=="function"&&t!==null){throw new TypeError("Super expression must either be null or a function")}Object.defineProperty(e,"prototype",{value:Object.create(t&&t.prototype,{constructor:{value:e,writable:true,configurable:true}}),writable:false});if(t)_setPrototypeOf(e,t)}function _setPrototypeOf(e,t){_setPrototypeOf=Object.setPrototypeOf||function e(t,r){t.__proto__=r;return t};return _setPrototypeOf(e,t)}function _createSuper(e){var t=_isNativeReflectConstruct();return function r(){var _=_getPrototypeOf(e),n;if(t){var a=_getPrototypeOf(this).constructor;n=Reflect.construct(_,arguments,a)}else{n=_.apply(this,arguments)}return _possibleConstructorReturn(this,n)}}function _possibleConstructorReturn(e,t){if(t&&(_typeof(t)==="object"||typeof t==="function")){return t}else if(t!==void 0){throw new TypeError("Derived constructors may only return object or undefined")}return _assertThisInitialized(e)}function _assertThisInitialized(e){if(e===void 0){throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}return e}function _isNativeReflectConstruct(){if(typeof Reflect==="undefined"||!Reflect.construct)return false;if(Reflect.construct.sham)return false;if(typeof Proxy==="function")return true;try{Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})));return true}catch(e){return false}}function _getPrototypeOf(e){_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function e(t){return t.__proto__||Object.getPrototypeOf(t)};return _getPrototypeOf(e)}var __signature__=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};var RecentOrders=function(_Component){_inherits(RecentOrders,_Component);var _super=_createSuper(RecentOrders);function RecentOrders(){var e;_classCallCheck(this,RecentOrders);for(var t=arguments.length,r=new Array(t),_=0;_<t;_++){r[_]=arguments[_]}e=_super.call.apply(_super,[this].concat(r));e.state={recentOrders:null};return e}_createClass(RecentOrders,[{key:"componentDidMount",value:function e(){this.getRecentOrders()}},{key:"getRecentOrders",value:function e(){var t=this;Api__WEBPACK_IMPORTED_MODULE_1__["a"].get("recentOrders.js").then((function(e){t.setState({recentOrders:e.data})})).catch((function(e){}))}},{key:"render",value:function e(){var t=this.state.recentOrders;return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"table-responsive"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("table",{className:"table table-hover mb-0"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("thead",null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("tr",null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("th",null,"Order ID"),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("th",null,"Invoice"),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("th",null,"Customer Name"),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("th",null,"Profitment"),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("th",null,"Status"))),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("tbody",null,t&&t.map((function(e,t){return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("tr",{key:t},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("td",null,e.id),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("td",null,e.invoice),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("td",null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"d-block fw-normal"},e.customerName),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"fs-12"},e.customerEmail)),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("td",null,"$",e.amount),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("td",null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"badge ".concat(e.labelClass)},e.status)))})))))}},{key:"__reactstandin__regenerateByEval",value:function __reactstandin__regenerateByEval(key,code){this[key]=eval(code)}}]);return RecentOrders}(react__WEBPACK_IMPORTED_MODULE_0__["Component"]);var _default=RecentOrders;__webpack_exports__["default"]=_default;(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(RecentOrders,"RecentOrders","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\RecentOrders.js");e.register(_default,"default","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\RecentOrders.js")})();(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;e&&e(module)})()}).call(this,__webpack_require__(7)(module))}}]);
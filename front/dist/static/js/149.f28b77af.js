(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[149],{1398:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.r(__webpack_exports__);(function(module){__webpack_require__.d(__webpack_exports__,"default",(function(){return Revenue}));var react__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__(0);var react__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);var Util_IntlMessages__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__(13);var Components_Charts_TinyPieChart__WEBPACK_IMPORTED_MODULE_2__=__webpack_require__(3253);function _typeof(e){"@babel/helpers - typeof";return _typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},_typeof(e)}(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;e&&e(module)})();function _classCallCheck(e,t){if(!(e instanceof t)){throw new TypeError("Cannot call a class as a function")}}function _defineProperties(e,t){for(var a=0;a<t.length;a++){var _=t[a];_.enumerable=_.enumerable||false;_.configurable=true;if("value"in _)_.writable=true;Object.defineProperty(e,_.key,_)}}function _createClass(e,t,a){if(t)_defineProperties(e.prototype,t);if(a)_defineProperties(e,a);Object.defineProperty(e,"prototype",{writable:false});return e}function _inherits(e,t){if(typeof t!=="function"&&t!==null){throw new TypeError("Super expression must either be null or a function")}Object.defineProperty(e,"prototype",{value:Object.create(t&&t.prototype,{constructor:{value:e,writable:true,configurable:true}}),writable:false});if(t)_setPrototypeOf(e,t)}function _setPrototypeOf(e,t){_setPrototypeOf=Object.setPrototypeOf||function e(t,a){t.__proto__=a;return t};return _setPrototypeOf(e,t)}function _createSuper(e){var t=_isNativeReflectConstruct();return function a(){var _=_getPrototypeOf(e),r;if(t){var n=_getPrototypeOf(this).constructor;r=Reflect.construct(_,arguments,n)}else{r=_.apply(this,arguments)}return _possibleConstructorReturn(this,r)}}function _possibleConstructorReturn(e,t){if(t&&(_typeof(t)==="object"||typeof t==="function")){return t}else if(t!==void 0){throw new TypeError("Derived constructors may only return object or undefined")}return _assertThisInitialized(e)}function _assertThisInitialized(e){if(e===void 0){throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}return e}function _isNativeReflectConstruct(){if(typeof Reflect==="undefined"||!Reflect.construct)return false;if(Reflect.construct.sham)return false;if(typeof Proxy==="function")return true;try{Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})));return true}catch(e){return false}}function _getPrototypeOf(e){_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function e(t){return t.__proto__||Object.getPrototypeOf(t)};return _getPrototypeOf(e)}var __signature__=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};var Revenue=function(_Component){_inherits(Revenue,_Component);var _super=_createSuper(Revenue);function Revenue(){_classCallCheck(this,Revenue);return _super.apply(this,arguments)}_createClass(Revenue,[{key:"render",value:function e(){var t=this.props.data;return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"card"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("h4",{className:"card-title"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_1__["a"],{id:"widgets.totalRevenue"})),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"row"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"col-sm-6 col-md-6 w-40 mx-auto"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Components_Charts_TinyPieChart__WEBPACK_IMPORTED_MODULE_2__["a"],{labels:t.chartData.labels,datasets:t.chartData.datasets,height:110,width:100})),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"col-sm-6 align-self-center display-n"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"clearfix mb-15"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"float-left"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"badge-primary ladgend"}," ")),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"float-left"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("h3",{className:"mb-0"},t.target),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"text-dark fs-14"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_1__["a"],{id:"widgets.target"})))),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"clearfix mb-15"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"float-left"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"badge-info ladgend"}," ")),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{className:"float-left"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("h3",{className:"mb-0"},t.lastWeek),react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("span",{className:"text-dark fs-14"},react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Util_IntlMessages__WEBPACK_IMPORTED_MODULE_1__["a"],{id:"widgets.monthly"})))))))}},{key:"__reactstandin__regenerateByEval",value:function __reactstandin__regenerateByEval(key,code){this[key]=eval(code)}}]);return Revenue}(react__WEBPACK_IMPORTED_MODULE_0__["Component"]);(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(Revenue,"Revenue","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\Revenue.js")})();(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;e&&e(module)})()}).call(this,__webpack_require__(7)(module))},3253:function(e,t,a){"use strict";(function(e){var _=a(0);var r=a.n(_);var n=a(356);var o=a(178);(function(){var t=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;t&&t(e)})();var l=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};var c={plugins:{legend:{display:false,labels:{fontColor:o["a"].legendFontColor}}}};var i=function e(t){var a=t.labels,_=t.datasets,o=t.width,l=t.height;var i={labels:a,datasets:_};return r.a.createElement(n["e"],{height:l,width:o,data:i,options:c})};var s=i;t["a"]=s;(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(c,"options","D:\\v3\\bloomtech-react\\src\\components\\Charts\\TinyPieChart.js");e.register(i,"TinyPieChart","D:\\v3\\bloomtech-react\\src\\components\\Charts\\TinyPieChart.js");e.register(s,"default","D:\\v3\\bloomtech-react\\src\\components\\Charts\\TinyPieChart.js")})();(function(){var t=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;t&&t(e)})()}).call(this,a(7)(e))}}]);
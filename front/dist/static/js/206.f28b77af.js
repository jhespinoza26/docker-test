(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[206],{1432:function(module,__webpack_exports__,__webpack_require__){"use strict";__webpack_require__.r(__webpack_exports__);(function(module){__webpack_require__.d(__webpack_exports__,"default",(function(){return SalesDoughnutChart}));var react__WEBPACK_IMPORTED_MODULE_0__=__webpack_require__(0);var react__WEBPACK_IMPORTED_MODULE_0___default=__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);var _amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__=__webpack_require__(2424);var _amcharts_amcharts4_charts__WEBPACK_IMPORTED_MODULE_2__=__webpack_require__(2423);var _amcharts_amcharts4_themes_animated__WEBPACK_IMPORTED_MODULE_3__=__webpack_require__(2432);var Components_RctCard__WEBPACK_IMPORTED_MODULE_4__=__webpack_require__(235);function _typeof(e){"@babel/helpers - typeof";return _typeof="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},_typeof(e)}(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.enterModule:undefined;e&&e(module)})();function _classCallCheck(e,t){if(!(e instanceof t)){throw new TypeError("Cannot call a class as a function")}}function _defineProperties(e,t){for(var r=0;r<t.length;r++){var _=t[r];_.enumerable=_.enumerable||false;_.configurable=true;if("value"in _)_.writable=true;Object.defineProperty(e,_.key,_)}}function _createClass(e,t,r){if(t)_defineProperties(e.prototype,t);if(r)_defineProperties(e,r);Object.defineProperty(e,"prototype",{writable:false});return e}function _inherits(e,t){if(typeof t!=="function"&&t!==null){throw new TypeError("Super expression must either be null or a function")}Object.defineProperty(e,"prototype",{value:Object.create(t&&t.prototype,{constructor:{value:e,writable:true,configurable:true}}),writable:false});if(t)_setPrototypeOf(e,t)}function _setPrototypeOf(e,t){_setPrototypeOf=Object.setPrototypeOf||function e(t,r){t.__proto__=r;return t};return _setPrototypeOf(e,t)}function _createSuper(e){var t=_isNativeReflectConstruct();return function r(){var _=_getPrototypeOf(e),a;if(t){var o=_getPrototypeOf(this).constructor;a=Reflect.construct(_,arguments,o)}else{a=_.apply(this,arguments)}return _possibleConstructorReturn(this,a)}}function _possibleConstructorReturn(e,t){if(t&&(_typeof(t)==="object"||typeof t==="function")){return t}else if(t!==void 0){throw new TypeError("Derived constructors may only return object or undefined")}return _assertThisInitialized(e)}function _assertThisInitialized(e){if(e===void 0){throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}return e}function _isNativeReflectConstruct(){if(typeof Reflect==="undefined"||!Reflect.construct)return false;if(Reflect.construct.sham)return false;if(typeof Proxy==="function")return true;try{Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})));return true}catch(e){return false}}function _getPrototypeOf(e){_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function e(t){return t.__proto__||Object.getPrototypeOf(t)};return _getPrototypeOf(e)}var __signature__=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default.signature:function(e){return e};_amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["f"](_amcharts_amcharts4_themes_animated__WEBPACK_IMPORTED_MODULE_3__["a"]);var SalesDoughnutChart=function(_Component){_inherits(SalesDoughnutChart,_Component);var _super=_createSuper(SalesDoughnutChart);function SalesDoughnutChart(){_classCallCheck(this,SalesDoughnutChart);return _super.apply(this,arguments)}_createClass(SalesDoughnutChart,[{key:"componentDidMount",value:function e(){var t=_amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["d"]("chartsales",_amcharts_amcharts4_charts__WEBPACK_IMPORTED_MODULE_2__["e"]);var r=t.series.push(new _amcharts_amcharts4_charts__WEBPACK_IMPORTED_MODULE_2__["f"]);r.dataFields.value="litres";r.dataFields.category="country";t.innerRadius=_amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["e"](30);r.slices.template.stroke=_amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["c"]("#fff");r.slices.template.strokeWidth=2;r.slices.template.strokeOpacity=1;r.slices.template.cursorOverStyle=[{property:"cursor",value:"pointer"}];r.alignLabels=false;r.labels.template.bent=true;r.labels.template.radius=3;r.labels.template.padding(0,0,0,0);r.ticks.template.disabled=true;var _=r.slices.template.filters.push(new _amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["a"]);_.opacity=0;var a=r.slices.template.states.getKey("hover");var o=a.filters.push(new _amcharts_amcharts4_core__WEBPACK_IMPORTED_MODULE_1__["a"]);o.opacity=.7;o.blur=5;t.legend=new _amcharts_amcharts4_charts__WEBPACK_IMPORTED_MODULE_2__["d"];t.data=[{country:"Product 1",litres:351.9},{country:"Product 2",litres:165.8},{country:"Product 3",litres:139.9},{country:"Product 4",litres:128.3}]}},{key:"componentWillUnmount",value:function e(){if(this.chart){this.chart.dispose()}}},{key:"render",value:function e(){return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(Components_RctCard__WEBPACK_IMPORTED_MODULE_4__["b"],null,react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div",{id:"chartsales",style:{width:"100%",height:"500px"}}))}},{key:"__reactstandin__regenerateByEval",value:function __reactstandin__regenerateByEval(key,code){this[key]=eval(code)}}]);return SalesDoughnutChart}(react__WEBPACK_IMPORTED_MODULE_0__["Component"]);(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.default:undefined;if(!e){return}e.register(SalesDoughnutChart,"SalesDoughnutChart","D:\\v3\\bloomtech-react\\src\\components\\Widgets\\SalesDoughnutChart.js")})();(function(){var e=typeof reactHotLoaderGlobal!=="undefined"?reactHotLoaderGlobal.leaveModule:undefined;e&&e(module)})()}).call(this,__webpack_require__(7)(module))}}]);
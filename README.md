# ClientApi
当年第一家公司搭的服务端架子




# 客户端最终
##  交互流程

```
seq
Client->>Server:  request(encode text)
Server->>Client:  response(encode text)
```

###  请求地址

    http://host:port/api/productId/productVersion/channelId/interface/interfaceVersion


productId | productVersion | channelId
---|---|---
android | 1.0 | default
ios | 1.1 | default

### 请求消息

    请求消息为一个json格式的文本


```
{
    "deviceId": "设备编号",
    "session": "会话数据",
    "mode": "数据模式",
    "body": "加密报文",
    "digest": "报文摘要"
}

```


### 响应消息

    响应消息为一个json格式的文本


```
{
    "mode": "数据模式",
    "body": "加密报文",
    "digest": "报文摘要",
    "result": "响应结果"
}

```

### Result


result | 含义
---|---
0 | 操作成功
-1 | 程序错误
-2 | 数据格式错误
-3 | 请求参数错误
-4 | 系统维护中
-5 | 服务器繁忙，请稍后再试
-6 | 登录超时


## 数据加密

    对于某些重要的接口，采用aes加密，秘钥对应协议版本

## 数据约定


    1. 时间格式为“YYYYMMDDHI24MISS”。
    2. 日期格式为“YYYYMMDD”。
    3. 密码均为32字节的MD5串。
    4. “是否”的逻辑：0否，1是。
    5. 所有金额单位均为分。

## 数据模式

```
1. mode=1，body=base64(zip(明文))，digest=md5(body密文)
2. mode=2, boyd=base64(aes(zip(明文),aesKey)),digest=md5(body密文)，明文数据使用PKCS5规则进行补位，加密模式使用AES-ECB。
```

## 会话数据

```
session=sid+$+ssign
sid=用户登录返回的sid
ssign=md5(interface+deviceId+sid+digest)

```

# 接口列表

**所有接口描述均为请求和响应中的body明文**

## 系统接口SYS
### 1000 启动初始化

    request
```


{
    "productId": "产品编号",
    "productVersion": "产品版本",
    "channelId": "渠道编号"
}

```

    response

```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述",
    "update": {
        "flag": "客户端升级标志",
        "version": "当前客户端最新版本",
        "size": "升级包大小描述",
        "url": "升级包下载URL地址",
        "desc": "升级描述"
    },
    "splash": "启动页图片URL",
    "adv": [
        {
            "imageUrl": "广告图片地址",
            "action": "跳转指令"
        }
    ]
}
```


```
update flag : 0为不升级，1为可升级，2为强制升级
```

```
action : url#http://www.163.com
```


```
升级描述 :
```



### 1001 升级检查


    request
```


{
    "productId": "产品编号",
    "productVersion": "产品版本",
    "channelId": "渠道编号"
}

```

    response


```
{
    "update": {
        "flag": "客户端升级标志",
        "version": "当前客户端最新版本",
        "size": "升级包大小描述",
        "url": "升级包下载URL地址",
        "desc": "升级描述"
    }
}
```

## 用户管理接口USR
### 1000 手机号注册

    request
```


{
    "phone": "手机号",
    "password": "登录密码(32字节MD5)",
    "activeCode": "验证码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述",
    "sid": "会话编号",
    "userName": "用户名",
    "phone": "手机号"
}
```

### 1001 登录

    request
```


{
    "phone": "手机号",
    "password": "登录密码(32字节MD5)"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述",
    "sid": "会话编号",
    "userName": "用户名",
    "phone": "手机号"
}
```

### 1002 用户注册获取验证码

    request
```


{
    "phone": "手机号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1003 用户找回登录密码获取验证码

    request
```


{
    "phone": "手机号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1004 用户找回登录密码-验证

    request
```


{
    "phone": "手机号",
    "activeCode": "验证码"
}

```

    response


```
{
    "token": "令牌",
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```


### 1005 用户找回登录密码-设置登录密码

    request
```


{
    "token": "令牌",
    "password": "密码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1006 用户修改登录密码

    request
```


{
    "oldPassword": "旧密码",
    "newPassword": "新密码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1007 用户修改支付密码

    request
```


{
    "phone": "手机号",
    "activeCode": "验证码",
    "payPassword": "新密码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1008 用户修改支付密码-获取验证码

    request
```


{
    "phone": "手机号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1009 用户修改绑定手机-获取验证码

    request
```


{
    "phone": "手机号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1010 用户修改绑定手机

    request
```


{
    "phone": "手机号",
    "activeCode": "验证码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1011 用户设置支付密码

    request
```


{
    "payPassword": "密码",
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1012 查询用户收货地址

    request
```


{

}

```

    response


```
{
    "addresses": [
        {
            "name": "收货人姓名",
            "phone": "收货人电话",
            "id": "编号",
            "province": "省",
            "city": "市",
            "area": "县区",
            "street": "街道",
            "zipCode": "邮编",
            "address": "详细地址(门牌号)"
        }
    ]
}
```

### 1013 新增用户收货地址

    request
```


{
    "name": "收货人姓名",
    "phone": "收货人电话",
    "province": "省",
    "city": "市",
    "area": "县区",
    "street": "街道",
    "zipCode": "邮编",
    "address": "详细地址(门牌号)"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1014 修改用户收货地址

    request
```


{
    "id": "编号",
    "name": "收货人姓名",
    "phone": "收货人电话",
    "province": "省",
    "city": "市",
    "area": "县区",
    "street": "街道",
    "zipCode": "邮编",
    "address": "详细地址(门牌号)"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1015 删除用户收货地址

    request
```


{
    "id": "编号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1016 用户退出登录

    request
```


{

}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1018 设置用户昵称

    request
```


{
    "nickName": "昵称"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1019 设置用户银行卡（提现的时候）

    request
```


{
    "bankName": "银行名称",
    "cardId": "银行卡号",
    "name":"开户人姓名",
    "activeCode": "验证码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1020 设置用户银行卡获取短信验证码



    request
```


{
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}

```

### 1021 查询用户银行卡信息



    request
```


{
	
}

```

    response


```
{
    "items":[
    	{
    "bankid":"",	
    "bankname": "银行名称",
    "cardId": "银行卡号"
    }
    ]
}

```
### 1022 用户提现
```    

request
```
```
{
	"money":"提现金额",
	"bankid":"银行id"
}
```
```
	response
```
```
{
	 "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```




##  搜索接口SAR
###  1000 商品搜索

        request
```
{
    "content":"搜索内容",
    "type":"搜索类型（1:全部  2:人气  3:销量）",
    "currentPage":"当前页都是int"
}
```
    response
```

{
    "items": [
        { 
            "goodId": "商品id", 
            "goodName": "商品名称", 
            "goodUrl":"url",
            "goodPrice": "平台价格", 
            "salNum": "购买数量"
        }
    ]
}

```







### 1001 店铺搜索
```
	request
```
```
{
	 "content":"搜索内容",
	 "type":"搜索类型1:全部  2:人气  3:销量",
	 "currentPage":"当前页都是int"
}
```
```
	response
```
```
	{
   "currentPage":"",
    "items": [
        {
            "shopId": "店铺id", 
            "shopName": "XXX", 
            "shopFeatures": "对商店的描述", 
            "logoUrl": "logourl", 
            "shopCommentStar": "点评/星级", 
            "shopAdress": "商店地址", 
            "saleType": "销售类型（韩料）", 
            "saleNum": "销量", 
            "advUrls": "url 用;分割"
            
        }
    ]
    ]
}
```
##  用户资金接口 ACT
### 1000 用户账户查询

    request
```
month 只有前后三个月 1本月
					2 前一个月
				3 前两个月
```
```
{	
	 "month":"月份",
     "type": "类型:1全部2充值3退款",
     "currentPage":"当前页都是int"
}

```

    response


```
{
    "items":[
        {
            "act_type": "类型",
            "logo": "logo url",
            "money": "金额",
            "type": "+,2",
            "desc": "描述",
            "time": "时间",
                    }
    ]
}
```


## 用户订单接口 ORD
### 1000 用户订单-查询列表

    request
```


{
    "type": "类型:1全部2待支付3待发货4待收货5待评价6退款",
    "pageNow": "当前页"
}

```

    response


```
{
    "pageNow": "当前页",
    "items": [
	        {	        	                 
            "orderId": "订单号", 
            "logo": "logo url", 
            "goodprice":"商品价格",           
            "desc": "商品描述", 
            "time": "时间", 
            "num": "购买数量", 
            "state": "状态", 
            "stateDesc": "状态描述", 
            "goodsSpec": "商品规格",                                            
            "shopName": "商铺名称",
	        "costprice":"市场价（划线的）",
	        "pid":"关联订单id",
	        "flag":"是否为主订单 true 是 false 不是"	               
	         }
    ]
}
```
### 1001 用户订单-普通确认收货

    request
```
{
    "orderId": "订单号",
    "payPassword": "支付密码"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1002 用户订单-删除

    request
```
{
    "orderId": "订单号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1003 用户订单-退货
```
      request
```
```
{
    "orderId": "订单号",
	"monand":"all/1/2",
	"reason":"1/2/3/4",
	"money":"",
	"wanttosay":"留言",
	"flag":"是否为正常退货的标识（true正常）"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1004 用户订单-取消

    request
```
{
    "orderId": "订单号",
    "reason": "取消原因"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1005 用户订单-商品评价

    request
```
{
    "orderId": "订单号",
    "goodStar": "商品评价1,2,3,4,5",
    "goodContent":"商品评价的内容",
    "goodsid":"商品id"    
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```


### 1006  用户订单-商铺的评价
```

request
```
```
{
	"orderId": "订单号",
    "shopStar": "店铺评分1,2,3,4,5",
    "logisticalStar":"物流评分",
	"shopid":"商铺id"
	}
```
```
    response
```
```
{

    "result": "返回状态码",
    "resultDesc": "返回码描述"

}
```
### 1007 用户订单-订单确认
        request
```
{
    "addressId": "地址id", 
    "Price": "实付金额",
    "balance":"余额", 
    "num": "购买数量（针对主订单）", 
    "note": "买家备注", 
    "sendTypeId": "", 
    "buyTypeId": "",
    "paySale":"订单总价", 
    "temid":"临时表id",
    "postPrice":"邮费"        
}
```

    response


```
{
    "orderId": "订单号",
    "result": "返回状态码",
    "resultDesc": "返回码描述"
}
```

### 1008 用户订单-订单提交
```
	request
```
```
{	
     "makeSure":{
	"goodsId":"商品的id",
	"buyNum":"",
	"shopId":"",
	"subid":"商品子id",
	"currentPrice":"当前价格"
	},
    "couldBuy":
	    [
	      {
	        "goodsId":"商品的id",
	        "subid":"商品子id",
                "price":"商品价格", 
                "buyNum":""
                      
              }
            ]
}

```
```
	response
```

```
{
   
    "provisionalId":"临时表的id",
    "result":"",
    "resultDesc":""
}
```


###  1009  用户订单-确认订单查询
```
   request
```
```
   {
   
    "provisionalId":"临时表的id"
   
   }
```
```
   response
```
```
   {
	     "temid":"临时表id",
    	"addresses":
		    {
            "addressid":"",
			"name":"",
			"phone":"",
			"address":""
		    },
		"returnTable":
		    {	
		    "goodPublicProperty":{
				"images":"",
				"goodId":"",
				"shopId":"",
				"shopName":"",
				"goodName":""
				
		    },
		    "makeSure":{
			"goodsId":"",
			"buyNum":"",		
			"subid":"商品子id",			
			"shopId":"",
			"price":"价格",
			"marketPrice":"市场价",
			"spec":"规格描述",
			},
		    "couldBuy":
			    [
			      {
			        "goodsId":"",
		                "price":"商品价格",
		                "marketPrice":"市场价",
		                "buyNum":"1",
		              
		                "subid":"商品子id",
		           
		                "shopId":"",
     	                "spec":"规格描述"
		              }
		            ]
	},
		"pay":[
			{
			"id":"支付方式id",
			"describe":"",
			"url":"支付方式logo"
			}
		       ],
		"post":
		[{"id":"配送方式id",
		"Post_name":"",
		"desc":"配送方式 "
		}
		],
		 "result": "返回状态码",
		 "resultDesc": "返回码描述",
         "balance":"余额"   ,
         "postPrice":"邮费"
   }
```
###  1010  用户订单-退货原因
```
	request
```
```
{

}
```
```
	response
```
```
{
 "item": [
        {
            "id": "", 
            "desc": ""
        }
    ]


}
```


### 1011 用户订单-订单详情
```
	request
```
```
{
	"orderid":"订单号",
	
	
	
	
}
```
```
	response
```
```
{
	
    "address": "详细地址",
    "persion":"收货人",
    "phone":"收货人电话",
    "returnTable": {
        "makeSureOrder": {
	        "orderId":"",
	        "orderType":"订单的总状态",
	        "orderTypeDesc":"订单的状态描述",
	        "orderSendType":"订单的发货状态",
	        "orderPayType":"订单的支付状态",
	        "orderRejectedType":"订单的退货状态",
            "goodsId": "", 
            "buyNum": "", 
            "goodurl": "", 
            "shopName":"店铺名",
            "goodsName": "商品名", 
            "price":"商品价格",
		    "marketPrice":"市场价",
            "willBuy": "规格描述"
        }, 
        "couldBuy": [
	
            {   
	            "order":{"orderId":" 返回整个Order表的所有属性",
	            "orderType":"订单的总状态",
	            "orderTypeDesc":"订单的状态描述",
		        "orderSendType":"订单的发货状态",
		        "orderPayType":"订单的支付状态",
		        "orderRejectedType":"订单的退货状态",
		        "create_time":"",
		        "pay_time":"付款时间",
		        "closing_time":"关闭时间",
		        "payback_time":"退款时间",
		        "send_time":"发货时间",
		        "getdell_time":"成交时间",
                "goodsId": "", 
                "price":"商品价格",
		        "marketPrice":"市场价", 
                "buyNum": "1", 
                "goodurl": ""
                } ,
                "goodsName": "商品名", 
                "willBuy": "规格描述"
            }
        ]
        
    }, 
    "note": "买家备注",
    "paySale":"支付金额",
    "yue":"余额支付",
    "postPrice":"邮费",
    "orderPrice":"订单总价",
    "orderId":"",
    "createTime":"",
    "payTime":"",
    "sendTime":"",
    "getdellTime":"成交时间",
    "sellerPhone":"卖家电话"
    }
```
### 1012 用户订单-取消原因

```
	request
```
```
{

}
```
```	
	response
```
```
{
	 "item": [
        {
            "id": "", 
            "desc": ""
        }
    ]
}
```


### 1012 用户订单-带有意向订单的确认收货
```
request
```
```
{
 "rejectFlag":"String 类型的 true:要退款 下面的rejectOrderId才会有值,false 无值走正常的确认收货",
 "rejectOrderId":"要退款的orderId",
 "rejectMoney":"退款的金额",
 
} 
```
```
response
```
```
{
"result": "返回状态码",
"resultDesc": "返回码描述"
}
```

## 用户支付接口 PAY
### 1000 支付方式查询

    request
```

{
 "orderId":""
 }

```

    response


```
{  
	
    "items": [
        {
            "payType": "支付类型",
            "payTypeName": "支付类型名称",
            "payTypeIcon": "支付类型图标URL",
            "recommend": "推荐标志(1推荐)"
        }
    ]
}
```

### 1001 支付宝插件-支付订单金额

    request
```

{
    "orderId":"订单号",
    "balance":"余额数"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述",
    "payContent": "支付宝控件数据"
}
```

### 1002 微信插件-支付订单金额

    request
```

{  
    "balance":"余额数",
    "orderId":"订单号"
}

```

    response


```
{
    "result": "返回状态码",
    "resultDesc": "返回码描述",
    "payContent": "微信控件数据"
}
```
### 1004查询用户余额
```
request
```
```
{
}
```
```
response
```
```
{
	 "balance":"余额数",
	 "result": "返回状态码",
	 "resultDesc": "返回码描述"
}
```




## 市场接口 MAR
### 1000 主题市场查询

    request
```
{
    "cityId": "城市编号",
    "pagenow":"页码"
}
```

    response


```
{
    "items": [
        {
            "marketId": "编号",
            "marketName": "主题名称",
            "marketDesc":"主题描述",
            "marketAdv": "市场广告图片url",
            "affiliatedPic":"附属图片（家电清凉节)"
        }
    ]
}
```


## 店铺接口 SHO
### 1000 热门店铺查询

    request
```
{
	"cityId": "城市编号",
	"pagenow":""
}

```

    response


```
{
    "items": [
        {            
            "shopLogo": "url",
            "marketId": "编号",
            "marketName": "店铺名称",
            "marketDesc":"主题描述",
            "affiliatedPic":"附属图片（家电清凉节)"
        }
    ]
}
```
### 1001 店铺基本信息
    request
```
{
	"shopid":"店铺id"
}

```

    response


```
{       
   "urlLogo":"店铺logo",
   "shopName":"店铺名称",
   "concernNum":"关注数量",
   "concernFlag":"是否关注",
   "backgroundPic":"背景图"
}
```
### 1002 进入店铺（所有产品）
```
		request
```
```
{
	"shopId":"店铺id",
    "type":"类别",
    "pagenow":""
 
  }
```
```
	response
```
```
{
	"items":[
	{
		"goodId":"商品id",
        "goodName":"商品名称",
        "goodUrl":"url",
        "goodPrice":"平台价格",
        "salNum":"购买数量"

	}
]
}
```
### 1003 店铺搜索（所有产品）
```
  request
```
```
 {
    "searchContent":"",
    "pageNow":"",
    "shopid":"商铺id"
 }
```
```
 response
```
```
 {
    "pageNow":"",
    "items":[
                {
	                "goodId":"商品id",
                     "goodName":"商品名称",
                    "goodUrl":"url",
                    "goodPrice":"平台价格",
                    "salNum":"购买数量"

	            }
            ]
 }
 
```
 
### 1004 店铺关注（关注店铺）
```
  
  request
```
```
  {
    "type":"是否关注1关注/0 不关注",
    "shopId":""
  }
```
```
  response
```
```
  {
  
    "result": "返回状态码",
    "resultDesc": "返回码描述",
  
  }
```

## 字典接口DIC
### 1000 全部导航分类

    request
```
{
}

```

    response


```
{
    "items": [
        {
            "id": "编号",
            "name": "名称",
            "items": [
                {
                    "id": "编号",
                    "name": "名称"
                }
            ]
        }
    ]
}
```


### 1001 省市县区

    request
```


{
}

```

    response
```
{
    "items": [
        {
            "id": "编号370000",
            "name": "名称山东省",
            "items": [
                {
                    "id": "编号370100",
                    "name": "名称济南市",
                    "items": [
                        {
                            "id": "编号370105",
                            "name": "名称天桥区"
                        }
                    ]
                }
            ]
        }
    ]
}
```

### 1002 首页快捷导航

    request
```
{
}

```

    response


```
{
    "items": [
        {
            "id": "编号",
            "name": "名称"  
        }
    ]
}
```

###  1003 点击导航
```
       request
```
```
{
    "navId":"导航id",
    "type":"1人气/2销量",
    "pagenow":"当前页"
}
```

        response
```

{
	"ClassName":"所选一级分类名称",
    "items":  [
     {
        "shopId":"店铺id",
        "shopName":"店铺名称",
       "shopLogo":"店铺logo",
        "shopUrl":"图片",
        "shopScore":"店铺评分",
        "sellNum":"销量",
        "shopclass":"shop分类"
      }
    ]
}




```
##   商品接口  GOO
###   1000 商品详情

    request
```
{
    "goodId":"商品id"
}
```

     response
```
{
      "shopId":"",
      "goodId":"",
      "shopurl":"店铺url",
      "shopName":"",
      "shopnum":"全部宝贝",
      "scrs":"收藏人数",
      "sendType":"返回是否支持急速快速1急速，2快速",
      "goodName":"",
      "bigImages":"每个url用;分割",
      "goodPrice":"市场价格",
      "discountPrice":"平台价",
     
      "goodsStar":[
			{
				"evaluateId":"商品评价的id",
				"evaluateStar":"商品评价的星级",
				"evaluateContent":"商品评价的内容"
			}
		],
      "salesNum":"月销量",
	  "postCost":"邮费",
      "shopAddress":"商家地址",
      "goodSpec":[
	    {"id":"",
	     "desc":"",
	      "item":[{
	            "id":"",
	            "desc":""}
	            ]
	    }
	    ],
    "price":[{"id":"",
    "key":"",
    "value":""}
    ],
    "urlGoods":"url"
}    
```
###  1001 查看所有评价
```
    request
```
```
{
	"goodid":"商品id",
	"type":"1 全部 2 好评， 3中评，4差评",
	"pagenow":""     
}
```
```
    response
```
```
{
	"items":[
		{
	"order_id":"",
	"good_star":"",
	"good_content":"评价详情"
	}
	]
}
```

##  配送接口  POT
### 1000 配送方式
```
    request
```
```
{

}
```

    response
```
{
    "items":[
    {"id":"配送方式id",
    "postName":"配送方式的名称",
    "desc":"配送方式描述"
    }
    ]
}
```


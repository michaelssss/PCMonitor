# PCMonitor
为什么要这么构造包结构：
	1) 同目录之间的包应该是同级的
	2) class应该调用子包和同级目录中的class
	3) 给予上级目录调用的等同于对外提供方法的应该提供Interface
	4) 包与包之间之间除了Interface的接口其他不可互相调用
	5) 不是包外可见的方法不要增加public关键字


关于CommonUtil这种存在，我们可以在包的根部写一个Abstract的Utils，然后每个包中写一个Utils并继承根包下的Utils（等效于只应该调用包内的class），如果有多个包共同调用的方法可以新建一个abstract表述清楚是哪几个package要调用，并继承根目录下的Utils，同时在包内的Util继承你刚编写的abstract Utils。
	


Junit编写说明：
	1) 每一个method编写一个Test
	2) 只关注Method的输入输出
	3) public方法直接调用

private方法用反射调用

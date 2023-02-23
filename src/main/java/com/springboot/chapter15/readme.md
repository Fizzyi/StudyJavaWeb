整个逻辑：
- （1）设计数据库，根据数据库编写POJO文件
- （2）根据业务需要编写dao文件，同时将sql写到对应的mapper文件中。
- （3）编写service文件和impl文件
- （4）编写controller文件



各个文件的内容：
- controller：接口设置相关
- service: 接口
- impl：接口的实现类，实现具体的业务逻辑
- dao:sql执行

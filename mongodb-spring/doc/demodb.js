
/* 创建一个数据库 */
use demodb2
/* db.集合名称.操作: 创建第一个集合时，会自动创建use指定的数据库 */
db.Student.insert({name:"jack",age:22})
/* 删除当前库 */
db.dropDatabase();
/* 数据库列表 */
show dbs;


/* 创建一个数据库 */
use demodb
/* db.集合名称.操作: 创建第一个集合时，会自动创建use指定的数据库 */
db.Student.insert({name:"jack",age:22})

/* 展示所有的集合 */
show collections;

/* 获取所有集合的名称 */
db.getCollectionNames();

/* 查询数据 */
db.Student.find();

db.Student.insert({name:"zhangsan",age:35})
db.Student.insert({name:"LiSi",age:41})

/* 查询满足条件的数据 {}中为条件 */
db.Student.find({name:"jack"});

/* 第一个{}为条件，第二个{}为是否要显示或隐藏某个字段1-显示，0-隐藏，没有书写的则为相仿值 */
db.Student.find({name:"jack"},{age:1});
db.Student.find({name:"jack"},{age:0});
/* > >= < <= */
db.Student.find({age:{$gt:22}});
db.Student.find({age:{$in:[22,41]}});
db.Student.find({age:{$ne:22}});

/* 或 */
db.Student.find({$or:[{age:{$ne:22}},{name:"LiSi"}]});
db.Student.findOne({$or:[{age:{$ne:22}},{name:"LiSi"}]});

/* null值 */
db.Student.insert({name:null,sex:1,age:29});
db.Student.find({name:null});
db.Student.find({name:{$in:[null],$exists:true}});

/* 数组查询 */
db.Student.insert({name:"wjh",sex:1,age:18,color:["red","blue","black"]});
db.Student.insert({name:"lpj",sex:1,age:22,color:["white","blue","black"]});

/* 数组才查询 */
db.Student.find({color:"white"});
/* 无论顺序，只要都含有这些值即可 */
db.Student.find({color:{$all:["black","blue"]}});
/* 值和顺序 */
db.Student.find({color:["red","blue","black"]});
db.Student.find({"color.0":"red"});

/* 排序 1代表升序，-1代表降序 */
db.Student.find().sort({age:1});
db.Student.find().sort({age:-1});
db.Student.find().sort({age:1,sex:1});

/* 分页 limit代表取多少个document(即pageSize)，
skip代表跳过前多少个document(即startIndex) */
db.Student.find().sort({age:1}).limit(4).skip(5);

/* 获取数量 */
db.Student.count({name:{$ne:null}});
db.Student.find({name:{$ne:null}}).count();

db.Student.insert({name:"ZhaoLiu",age:35})
/* 删除数据 */
db.Student.remove({name:"ZhaoLiu"});

/* 更新数据 */
/* 1.整体替换
先查询name=jack的所有document，然后将name=jack的所有document都替换为{age:55}，其它filed都没有了。 
 */
db.Student.find({name:"jack"});
db.Student.update({name:"jack"},{age:71});
db.Student.find({age:71});
/* 2.更新指定的字段 */
db.Student.update({age:71},{$set:{name:"jack"}});
db.Student.find({name:"jack"});
/* 增加field */
db.Student.update({name:"jack"},{$inc:{sex:1}});
db.Student.find({name:"jack"});
/* 数字增量 */
db.Student.update({name:"jack"},{$inc:{age:20}},true);
db.Student.find({name:"jack"});





/**
 * 描述: 
 * MongoDbTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.mongo;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.bson.Document;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MongoDbTest
 */
public final class MongoDbTest extends BaseTest {

	private static final String host = "127.0.0.1";
	
	private static final int port = 27017;
	
	private static final String databaseName = "demodb";
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMongoDbClient() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testMongoDbClient =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCollection() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testCollection =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			MongoCollection<Document> collection = database.getCollection("Student");
			Document document = new Document();
			document.append("name", "wangwu").append("age", 3).append("sex", 1);
			
			collection.insertOne(document);
		
			System.out.println(collection.count());
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRemove() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			Document document = new Document();
			document.append("name", "wangwu").append("age", 3).append("sex", 1);
			//document.append("_id", new Document("ObjectId", "5975bbeaa8a0739f6cb781a6"));
			// 删除一个
			collection.deleteOne(document);
		
			System.out.println(collection.count());
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testRemove =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			Document filter = new Document();
			filter.append("name", "lpj");
			
			Document update = new Document();
			update.put("$set", new Document("age", 65));
			
			// 更新一个
			collection.updateOne(filter, update);
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFind() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> cursor2 = findIterable.iterator();
		    while(cursor2.hasNext())
			{
				System.out.println(cursor2.next());
			}
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testFind =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFindOne() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testFindOne =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSort() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			Document sort = new Document();
			sort.append("age", 1);
			FindIterable<Document> findIterable = collection.find().sort(sort);
			MongoCursor<Document> cursor2 = findIterable.iterator();
		    while(cursor2.hasNext())
			{
				System.out.println(cursor2.next());
			}
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testSort =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLimit() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			Document sort = new Document();
			sort.append("age", 1);
			FindIterable<Document> findIterable = collection.find().sort(sort).limit(2).skip(8);
			MongoCursor<Document> cursor2 = findIterable.iterator();
		    while(cursor2.hasNext())
			{
				System.out.println(cursor2.next());
			}
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testLimit =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCount() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			MongoCollection<Document> collection = database.getCollection("Student");
			Document sort = new Document();
			sort.append("age", 1);
			FindIterable<Document> findIterable = collection.find().sort(sort).limit(2).skip(8);
			MongoCursor<Document> cursor2 = findIterable.iterator();
		    while(cursor2.hasNext())
			{
				System.out.println(cursor2.next());
			}
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testCount =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();
			MongoCursor<String> cursor = names.iterator();
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			Integer pageSize =3;
			Integer startIndex = 8;
			MongoCollection<Document> collection = database.getCollection("Student");
			Document sort = new Document();
			sort.append("age", 1);
			FindIterable<Document> findIterable = collection.find().sort(sort).limit(pageSize).skip(startIndex);
			MongoCursor<Document> cursor2 = findIterable.iterator();
		    while(cursor2.hasNext())
			{
				System.out.println(cursor2.next());
			}
			
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testSearch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCursor() {
		try {
			
			// 创建mongo客户端
			MongoClient client = new MongoClient(host, port);
			
			// 获取指定的数据库，即use xxdatabse
			MongoDatabase database = client.getDatabase(databaseName);
			// 列出所有的集合名称
			MongoIterable<String> names = database.listCollectionNames();

			MongoCursor<String> cursor = names.iterator();
			
			while (cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			
			// 关闭mongo数据库
			client.close();
			
		} catch (Exception e) {
			log.error("testCursor =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}

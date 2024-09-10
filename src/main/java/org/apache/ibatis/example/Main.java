package org.apache.ibatis.example;

import org.apache.ibatis.example.entity.ScheduleSettingPO;
import org.apache.ibatis.example.mapper.ScheduleSettingMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
  public static void main(String[] args) {
    String resource = "mybatis-config.xml";
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory = null;
    //初始化
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = null;
    //二级缓存
    // SqlSession sqlSession1 = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
//      sqlSession1 = sqlSessionFactory.openSession();

      ScheduleSettingMapper scheduleSettingMapper = sqlSession.getMapper(ScheduleSettingMapper.class);

//      ScheduleSettingMapper scheduleSettingMapper1 = sqlSession1.getMapper(ScheduleSettingMapper.class);

      ScheduleSettingPO scheduleSettingPO = scheduleSettingMapper.findByJobId("test");
//      sqlSession.commit();
//      ScheduleSettingPO scheduleSettingPO1 = scheduleSettingMapper1.findByJobId("test");

      System.out.println("///// 数据库数据为："+scheduleSettingPO.toString());
//      System.out.println("///// 数据库数据为："+scheduleSettingPO1.toString());


      sqlSession.commit();
//      sqlSession1.commit();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      sqlSession.rollback();
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
  }
}

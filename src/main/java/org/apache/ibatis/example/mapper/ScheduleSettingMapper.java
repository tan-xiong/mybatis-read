package org.apache.ibatis.example.mapper;

import org.apache.ibatis.example.entity.ScheduleSettingPO;

/**
 * @author tanxiong
 * @date 2024/4/18 9:22
 */
public interface ScheduleSettingMapper {

  /**
   *
   * 根据任务ID查询
   * @param jobId
   * @return
   */
   ScheduleSettingPO findByJobId(String jobId);
}

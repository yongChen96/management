package com.example.management.service.impl;

import com.example.management.entity.OperateLog;
import com.example.management.mapper.OperateLogMapper;
import com.example.management.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-09-01
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}

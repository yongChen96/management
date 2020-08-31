package com.example.commons.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.commons.mybatisplus.config.SuperEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @ClassName: SqlMetaObjectHandler
 * <p> MyBatisPlus自定义字段自动填充处理类 - 实体类中使用 @TableField注解 </p>
 * <p> 注意前端传值时要为null </p>
 * @Author: yongchen
 * @Date: 2020/8/31 17:14
 **/
@Slf4j
public class SqlMetaObjectHandler implements MetaObjectHandler {

    private IdGenerator idGenerator;

    /**
     * 主键id类型
     */
    private final static String ID_TYPE_STRING = "java.lang.String";

    /**
     * 实体类型判断符
     */
    private final static String ET = "et";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        boolean flag = true;
        if (metaObject.getOriginalObject() instanceof SuperEntity) {
            Object oldId = ((SuperEntity) metaObject.getOriginalObject()).getId();
            if (oldId != null) {
                flag = false;
            }

            SuperEntity superEntity = (SuperEntity) metaObject.getOriginalObject();
            if (superEntity.getCreateTime() == null){
                this.setFieldValByName(SuperEntity.CREATE_TIME, LocalDateTime.now(), metaObject);
            }
            if (superEntity.getCreateUser() == null){
                if (ID_TYPE_STRING.equals(metaObject.getGetterType(SuperEntity.CREATE_USER).getName())){
                    this.setFieldValByName(SuperEntity.CREATE_USER, String.valueOf(""), metaObject);
                }else {
                    this.setFieldValByName(SuperEntity.CREATE_USER, null, metaObject);
                }
            }

            update(metaObject, superEntity, "");

            if (flag) {
                UUID id = idGenerator.generateId();
                if (ID_TYPE_STRING.equals(metaObject.getGetterType(SuperEntity.ID).getName())) {
                    this.setFieldValByName(SuperEntity.ID, String.valueOf(id), metaObject);
                } else {
                    this.setFieldValByName(SuperEntity.ID, id, metaObject);
                }
            }
        }
        log.info("insert fill end ....");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        if (metaObject.getOriginalObject() instanceof SuperEntity) {
            SuperEntity superEntity = (SuperEntity) metaObject.getOriginalObject();
            update(metaObject, superEntity, "");
        }else {
            Object et = metaObject.getValue(ET);
            if (et != null && et instanceof SuperEntity) {
                SuperEntity superEntity = (SuperEntity)et;
                update(metaObject, superEntity, ET + ".");
            }
        }
        log.info("update fill end....");
    }

    private void update(MetaObject metaObject, SuperEntity superEntity, String et){
        if (superEntity.getUpdateTime() == null){
            this.setFieldValByName(SuperEntity.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
        if (superEntity.getUpdateUser() == null){
            if (ID_TYPE_STRING.equals(metaObject.getGetterType(et + SuperEntity.UPDATE_USER).getName())){
                this.setFieldValByName(SuperEntity.UPDATE_USER, String.valueOf(""), metaObject);
            }else {
                this.setFieldValByName(SuperEntity.UPDATE_USER, null, metaObject);
            }
        }
    }
}

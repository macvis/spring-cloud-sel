package com.tee.springcloudsel.order.mapper;

import com.tee.springcloudsel.order.domain.OrderMaster;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youchao.wen
 * @date 2018/9/23.
 */
@Component
public interface OrderMasterMapper {

    /**
     * 查询所有数据
     */
    List<OrderMaster> selectAll();


}

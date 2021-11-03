//
//package com.anrong.margin.market.entity;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//import com.anrong.margin.common.entity.BaseEntity;
//import com.anrong.margin.common.enums.CRModifyType;
//import com.anrong.margin.common.serializer.DateSerializer;
//import com.anrong.margin.common.serializer.SuperEnumSerialize;
//
///**
// * ConversionRate 变更记录
// * 
// * @author pis
// * 2013年12月19日 上午11:25:10
// * @version V1.0
// */
//@Entity
//@Table(name="market_conversion_rate_log")
//public class ConversionRateLog extends BaseEntity {
//    /**
//     * 
//     */
//    private static final long serialVersionUID = -9092047332753304539L;
//
//    private ConversionRate conversionRate;//变更后新增的记录
//    private CRModifyType modifyType;
//    private Date processDate;
//    
//    @ManyToOne
//    @JoinColumn(name = "conversion_rate_id")
//    public ConversionRate getConversionRate() {
//        return conversionRate;
//    }
//    public void setConversionRate(ConversionRate conversionRate) {
//        this.conversionRate = conversionRate;
//    }
//    
//    @JsonSerialize(using = SuperEnumSerialize.class)
//    public CRModifyType getModifyType() {
//        return modifyType;
//    }
//    public void setModifyType(CRModifyType modifyType) {
//        this.modifyType = modifyType;
//    }
//    
//    @JsonSerialize(using=DateSerializer.class)
//    public Date getProcessDate() {
//        return processDate;
//    }
//    
//    public void setProcessDate(Date processDate) {
//        this.processDate = processDate;
//    }
//}

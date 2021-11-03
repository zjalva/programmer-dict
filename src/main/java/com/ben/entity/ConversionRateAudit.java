//package com.anrong.margin.market.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//import com.anrong.margin.common.entity.BaseEntity;
//import com.anrong.margin.common.enums.AuditStatusEnum;
//import com.anrong.margin.common.enums.UpdateSrcEnum;
//import com.anrong.margin.common.serializer.SuperEnumSerialize;
//import com.anrong.margin.common.serializer.TimeSerializer;
//import com.anrong.margin.user.entity.User;
//
///**
// * @Title: ConversionRateAudit.java
// * @Description: credit entity Copyright: Copyright (c) 2013 Company:安融科技有限公司
// * 
// * @author Mark
// * @version V1.0
// */
//@Entity
//@Table(name = "market_conversion_rate_audit")
//public class ConversionRateAudit extends BaseEntity {
//
//    /**
//	 * 
//	 */
//    private static final long serialVersionUID = 5224906475596676149L;
//
//    @JsonSerialize(using = SuperEnumSerialize.class)
//    private UpdateSrcEnum src;
//
//    @JsonSerialize(using = SuperEnumSerialize.class)
//    private AuditStatusEnum status;
//
//    private ConversionRate conversionRate;
//
//    private Security security;
//    private boolean isFinancing;
//    private boolean isLending;
//    private String organizationName;
//    private double rate;
//    private double financingRate;
//    private double lendingRate;
//
//    private Date effectiveDate;
//    private boolean isEnabled;
//
//    private boolean isCollateral;
//
//    private Date submitTime;
//    private Date appTime;
//    private User approver;
//    private User submitter;
//    
//    @JsonSerialize(using=TimeSerializer.class)
//    public Date getSubmitTime() {
//        return submitTime;
//    }
//
//    public void setSubmitTime(Date submitTime) {
//        this.submitTime = submitTime;
//    }
//
//    public Date getAppTime() {
//        return appTime;
//    }
//
//    public void setAppTime(Date appTime) {
//        this.appTime = appTime;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "approver")
//    public User getApprover() {
//        return approver;
//    }
//
//    public void setApprover(User approver) {
//        this.approver = approver;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "submitter")
//    public User getSubmitter() {
//        return submitter;
//    }
//
//    public void setSubmitter(User submitter) {
//        this.submitter = submitter;
//    }
//
//    public UpdateSrcEnum getSrc() {
//        return src;
//    }
//
//    public void setSrc(UpdateSrcEnum src) {
//        this.src = src;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "conversion_rate_id")
//    public ConversionRate getConversionRate() {
//        return conversionRate;
//    }
//
//    public void setConversionRate(ConversionRate conversionRate) {
//        this.conversionRate = conversionRate;
//    }
//
//    public AuditStatusEnum getStatus() {
//        return status;
//    }
//
//    public void setStatus(AuditStatusEnum status) {
//        this.status = status;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "sec_id")
//    public Security getSecurity() {
//        return security;
//    }
//
//    public void setSecurity(Security security) {
//        this.security = security;
//    }
//
//    @Column(name = "is_financing")
//    public boolean getIsFinancing() {
//        return isFinancing;
//    }
//
//    public void setIsFinancing(boolean isFinancing) {
//        this.isFinancing = isFinancing;
//    }
//
//    @Column(name = "is_lending")
//    public boolean getIsLending() {
//        return isLending;
//    }
//
//    public void setIsLending(boolean isLending) {
//        this.isLending = isLending;
//    }
//
//    public String getOrganizationName() {
//        return organizationName;
//    }
//
//    public void setOrganizationName(String organizationName) {
//        this.organizationName = organizationName;
//    }
//
//    public double getRate() {
//        return rate;
//    }
//
//    public void setRate(double rate) {
//        this.rate = rate;
//    }
//
//    public double getFinancingRate() {
//        return financingRate;
//    }
//
//    public void setFinancingRate(double financingRate) {
//        this.financingRate = financingRate;
//    }
//
//    public double getLendingRate() {
//        return lendingRate;
//    }
//
//    public void setLendingRate(double lendingRate) {
//        this.lendingRate = lendingRate;
//    }
//
//    public Date getEffectiveDate() {
//        return effectiveDate;
//    }
//
//    public void setEffectiveDate(Date effectiveDate) {
//        this.effectiveDate = effectiveDate;
//    }
//
//    @Column(name = "is_enabled")
//    public boolean getIsEnabled() {
//        return isEnabled;
//    }
//
//    public void setIsEnabled(boolean isEnabled) {
//        this.isEnabled = isEnabled;
//    }
//
//    @Column(name = "is_collateral")
//    public boolean getIsCollateral() {
//        return isCollateral;
//    }
//
//    public void setIsCollateral(boolean isCollateral) {
//        this.isCollateral = isCollateral;
//    }
//}

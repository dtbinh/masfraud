package masfraud.base.to;

import masfraud.base.constants.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Marcos Pestana
 *
 */
public class RedemptionProductTO implements Serializable{

	private static final long serialVersionUID = 6941605177927315064L;
	
	private Long idProduct;
	private Long id;
	private String idSkuSupplier;
	private AddressTemplateTO addressTemplateTO;
    private Integer idMemberDeliveryAddress;
	private String addressValue;
	private Integer quatity;
	private BigDecimal freightValue;
    private BigDecimal totalValue;
    private BigDecimal taxesValue;
    private BigDecimal totalDiscount;
    private Integer idOrderStatus;
    private String supplierStatusCode;	
    private BigDecimal totalPoints;
	private String deliveryDate;
	private SupplierTO supplier;	
	private BigDecimal conversionRate;
    private BigDecimal adjustFactor;
	private String adjustFactorPercentual;
	private Date checkoutDate;
	private String cancellationReason;
	private UserTO userTO;
	private BigDecimal regularPoints;
    private Integer idOrder;
    private Integer idOrderItem;
    private String productName;
    private String orderItemSupplierId;
    private String idRedemptionChannel;
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdSkuSupplier() {
		return idSkuSupplier;
	}
	public void setIdSkuSupplier(String idSkuSupplier) {
		this.idSkuSupplier = idSkuSupplier;
	}
	public AddressTemplateTO getAddressTemplateTO() {
		return addressTemplateTO;
	}
	public void setAddressTemplateTO(AddressTemplateTO addressTemplateTO) {
		this.addressTemplateTO = addressTemplateTO;
	}
	public Integer getIdMemberDeliveryAddress() {
		return idMemberDeliveryAddress;
	}
	public void setIdMemberDeliveryAddress(Integer idMemberDeliveryAddress) {
		this.idMemberDeliveryAddress = idMemberDeliveryAddress;
	}
	public String getAddressValue() {
		return addressValue;
	}
	public void setAddressValue(String addressValue) {
		this.addressValue = addressValue;
	}
	public Integer getQuatity() {
		return quatity;
	}
	public void setQuatity(Integer quatity) {
		this.quatity = quatity;
	}
	public BigDecimal getFreightValue() {
		return freightValue;
	}
	public void setFreightValue(BigDecimal freightValue) {
		this.freightValue = freightValue;
	}
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	public BigDecimal getTaxesValue() {
		return taxesValue;
	}
	public void setTaxesValue(BigDecimal taxesValue) {
		this.taxesValue = taxesValue;
	}
	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	public Integer getIdOrderStatus() {
		return idOrderStatus;
	}
	public void setIdOrderStatus(Integer idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}
	public String getSupplierStatusCode() {
		return supplierStatusCode;
	}
	public void setSupplierStatusCode(String supplierStatusCode) {
		this.supplierStatusCode = supplierStatusCode;
	}
	public BigDecimal getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(BigDecimal totalPoints) {
		this.totalPoints = totalPoints;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public SupplierTO getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierTO supplier) {
		this.supplier = supplier;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getAdjustFactor() {
		return adjustFactor;
	}
	public void setAdjustFactor(BigDecimal adjustFactor) {
		this.adjustFactor = adjustFactor;
	}
	public String getAdjustFactorPercentual() {
		return adjustFactorPercentual;
	}
	public void setAdjustFactorPercentual(String adjustFactorPercentual) {
		this.adjustFactorPercentual = adjustFactorPercentual;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	public UserTO getUserTO() {
		return userTO;
	}
	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}
	public BigDecimal getRegularPoints() {
		return regularPoints;
	}
	public void setRegularPoints(BigDecimal regularPoints) {
		this.regularPoints = regularPoints;
	}

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderItemSupplierId() {
        return orderItemSupplierId;
    }

    public void setOrderItemSupplierId(String orderItemSupplierId) {
        this.orderItemSupplierId = orderItemSupplierId;
    }

    public String getIdRedemptionChannel() {
        return idRedemptionChannel;
    }

    public void setIdRedemptionChannel(String idRedemptionChannel) {
        this.idRedemptionChannel = idRedemptionChannel;
    }
    
    public String getOrderStatus(){
    	if(this.idOrderStatus != null){
    		return OrderStatus.getById(this.idOrderStatus).name();
    	}
    	return null;
    }
}

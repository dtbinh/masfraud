package masfraud.base.constants;

/**
 * User: eliel
 * Date: 15/07/13
 * Time: 13:36
 */
public enum OrderStatus {
    IN_CART(1),
    CANCELLED(2),
    FINALIZED(3),
    NOT_PROCESSED(4),
    CHECKING_SUPPLIER(5),
    REMOVED(6),
    CONFIRMED(7),
    CONFIRMED_WITH_ERRORS(8),
    DELIVERED(9),
    SUPPLIER_CANCELLED(10),
    DELIVERED_WITH_ERRORS(11),
    BILLED(12) /** Conciliação */,
    MANUALLY_DELIVERED(13), /** Manually Registered Product */
    ;


    private Integer id;

    private OrderStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static OrderStatus getById(Integer id) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getId().intValue() == id.intValue()) {
                return orderStatus;
            }
        }
        return null;
    }

}

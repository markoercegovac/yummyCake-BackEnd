package yummy.cake.com.enums;

public enum RoleEnum {
    ROLE_CUSTOMER("CUSTOMER"),
    ROLE_OWNER("OWNER");

    public final String value;

    RoleEnum(String value){
        this.value = value;
    }

}

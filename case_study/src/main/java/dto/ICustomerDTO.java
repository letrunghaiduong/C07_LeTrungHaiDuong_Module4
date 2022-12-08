package dto;

import com.casestudy.model.customer.CustomerType;

public interface ICustomerDTO {
    public int getId();
    public String getName();
    public String getGender();
    public String getAddress();
    public CustomerType getCustomerType();
}

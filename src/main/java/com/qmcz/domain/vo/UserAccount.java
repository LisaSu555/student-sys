package com.qmcz.domain.vo;

import com.qmcz.domain.User;
import lombok.Data;

@Data
public class UserAccount extends User {
    private String username;
    private String psw;
}

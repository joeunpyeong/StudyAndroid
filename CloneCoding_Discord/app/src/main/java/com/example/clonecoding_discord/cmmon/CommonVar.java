package com.example.clonecoding_discord.cmmon;

import com.example.clonecoding_discord.vo.UserVO;

public class CommonVar {
    //안드로이드는 스프링과 다름.(Session)
    //static변수 활용
    public static UserVO loginInfo;
    public static UserVO newUserInfo=new UserVO();

    public static UserVO friendInfo=new UserVO();
}

package com.mantis.api.data;

import com.mantis.api.dto.AccessLevelDTO;
import com.mantis.api.dto.UserDTO;
import com.mantis.api.utils.SharedData;

import static com.mantis.api.utils.DataFaker.getRandomBoolean;
import static com.mantis.api.utils.DataFaker.getRandomString;

public class UserDataTest {

    public static UserDTO setValue() {
        UserDTO userDTO = new UserDTO();
        AccessLevelDTO accessLevelDTO = new AccessLevelDTO("developer");
        String realName = getRandomString();

        userDTO.setUsername("user" + realName + getRandomString());
        userDTO.setPassword(getRandomString());
        userDTO.setRealName(realName);
        userDTO.setEmail(realName.replace(" ", "") + "@" + getRandomString().replace(" ", "") + ".com");
        userDTO.setAccessLevelDTO(accessLevelDTO);
        userDTO.setEnabled(getRandomBoolean());
        userDTO.setProtected(getRandomBoolean());

        SharedData.put("userDTO", userDTO);
        return userDTO;
    }
}
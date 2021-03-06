package com.stackcimplify.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.stackcimplify.restservices.dtos.UserMsDto;
import com.stackcimplify.restservices.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	//User To UserMsDto
		@Mappings({
		@Mapping(source= "email", target="emailaddress"),
		@Mapping(source = "role", target="rolename")
		})
		UserMsDto userToUserMsDto(User user);
		
		//List<User> to List<UserMsDto>
		List<UserMsDto> usersToUserDtos(List<User> users);

}

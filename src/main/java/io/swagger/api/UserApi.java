/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-08T08:21:17.323Z[GMT]")
@Validated
public interface UserApi {

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    @RequestMapping(value = "/user",
        method = RequestMethod.POST)
    ResponseEntity<Void> createUser(@NotNull @Parameter(in = ParameterIn.QUERY, description = "User object" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "user", required = true) User user);


    @Operation(summary = "Delete user", description = "This can only be done by the logged in user.", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid username supplied"),
        
        @ApiResponse(responseCode = "404", description = "User not found") })
    @RequestMapping(value = "/user/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@Min(1L) @Max(10L) @Parameter(in = ParameterIn.PATH, description = "The name that needs to be deleted", required=true, schema=@Schema(allowableValues={  }, minimum="1", maximum="10"
)) @PathVariable("id") Long id);


    @Operation(summary = "Get user by user id", description = "", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid userId supplied"),
        
        @ApiResponse(responseCode = "404", description = "User not found") })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@Min(1L) @Max(10L) @Parameter(in = ParameterIn.PATH, description = "The name that needs to be fetched. ", required=true, schema=@Schema(allowableValues={  }, minimum="1", maximum="10"
)) @PathVariable("id") Long id);


    @Operation(summary = "Logs user into the system", description = "", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid username/password supplied") })
    @RequestMapping(value = "/user/login",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> loginUser(@NotNull @Parameter(in = ParameterIn.QUERY, description = "The user name for login" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "username", required = true) String username, @NotNull @Parameter(in = ParameterIn.QUERY, description = "The password for login in clear text" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "password", required = true) String password);


    @Operation(summary = "Logs out current logged in user session", description = "", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    @RequestMapping(value = "/user/logout",
        method = RequestMethod.GET)
    ResponseEntity<Void> logoutUser();


    @Operation(summary = "Updated user", description = "This can only be done by the logged in user.", tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
        
        @ApiResponse(responseCode = "404", description = "User not found") })
    @RequestMapping(value = "/user/{id}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "name that need to be updated", required=true, schema=@Schema()) @PathVariable("id") String id, @NotNull @Parameter(in = ParameterIn.QUERY, description = "User object" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "user", required = true) User user);

}


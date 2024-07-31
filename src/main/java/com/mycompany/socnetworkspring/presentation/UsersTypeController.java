package com.mycompany.socnetworkspring.presentation;


import com.mycompany.socnetworkspring.exception.ResourceNotFoundException;
import com.mycompany.socnetworkspring.percistence.dto.UsersTypeDTO;
import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import com.mycompany.socnetworkspring.service.UsersTypeService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-types")
public class UsersTypeController {
    private static final Logger logger = LoggerFactory.getLogger(UsersTypeController.class);

    private UsersTypeService usersTypeService;

    @Autowired
    public UsersTypeController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

  @GetMapping("/")
    public @ResponseBody List<UsersType> getAllUsersTypes() {
      return usersTypeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional<UsersType>> getUserTypeById(@PathVariable Long id) {
        Optional<UsersType> usersType = usersTypeService.findById(id);
        return ResponseEntity.ok(usersType);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUsersType(@PathVariable Long id) {
      usersTypeService.deleteUsersType(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<UsersType> createUsersType(@RequestBody UsersTypeDTO newUserTypeDTO, HttpServletRequest request) {
        logger.info("Received request to create UsersType: {}", newUserTypeDTO);

        UsersType newUserType = new UsersType();
        newUserType.setUsersType(newUserTypeDTO.getUsersType());
        newUserType.setRole(newUserTypeDTO.getRole());

        try {
            UsersType createdUsersType = usersTypeService.createUsersType(newUserType);
            if (createdUsersType != null) {
                URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                        .path("/{id}")
                        .buildAndExpand(createdUsersType.getId())
                        .toUri();
                logger.info("Successfully created UsersType with ID: {}", createdUsersType.getId());
                return ResponseEntity.created(location).body(createdUsersType);
            } else {
                logger.error("Failed to create UsersType");
                return ResponseEntity.status(500).body(null);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while creating UsersType", e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<UsersType> updateUsersType(@PathVariable("id") Long id, @RequestBody UsersTypeDTO updateUserTypeDTO, HttpServletRequest request) {
        logger.info("Received request to update UsersType with ID: {}", id);

        try {
            UsersType updatedUsersType = usersTypeService.updateUsersType(id, updateUserTypeDTO);
            URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                    .path("/{id}")
                    .buildAndExpand(updatedUsersType.getId())
                    .toUri();
            logger.info("Successfully updated UsersType with ID: {}", updatedUsersType.getId());
            return ResponseEntity.ok(updatedUsersType);
        } catch (ResourceNotFoundException e) {
            logger.error("Error updating UsersType: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("Exception occurred while updating UsersType", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

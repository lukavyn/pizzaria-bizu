package br.com.pizzariabizu.backend.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.pizzariabizu.backend.model.UserModel;
import br.com.pizzariabizu.backend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cad_user")

public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByEmail(userModel.getEmail());
        if(user != null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        var senhaHashed = BCrypt.withDefaults().hashToString(12, userModel.getSenha().toCharArray());
        userModel.setSenha(senhaHashed);
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }






}

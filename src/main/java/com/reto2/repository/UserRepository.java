package com.reto2.repository;

import com.reto2.interfaces.UserInterface;
import com.reto2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserInterface userCrudRepository;

    /**
     * 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Obtener el usuario
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Crear usuario
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * Actualizar usuario
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    /**
     * Eliminar usuario
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    /**
     * Verificar si email existe
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     * Autenticarse en la página
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Mes de cumpleaños
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}

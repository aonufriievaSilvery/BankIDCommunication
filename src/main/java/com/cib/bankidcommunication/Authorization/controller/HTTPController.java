package com.cib.bankidcommunication.Authorization.controller;

import com.cib.bankidcommunication.Authorization.model.Request;
import com.cib.bankidcommunication.Authorization.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HTTPController {
    private final RequestService requestService;
    @Autowired
    public HTTPController(RequestService requestService) {
        this.requestService = requestService;
    }
    @PostMapping(value = "/requests")
    public ResponseEntity<?> create(@RequestBody Request request) {
        requestService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/requests")
    public ResponseEntity<List<Request>> read() {
        final List<Request> requests = requestService.readAll();

        return requests != null &&  !requests.isEmpty()
                ? new ResponseEntity<>(requests, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/requests/{login}")
    public ResponseEntity<Request> read(@PathVariable(name = "login") String login) {
        final Request request = requestService.read(login);

        return request != null
                ? new ResponseEntity<>(request, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/requests/{login}")
    public ResponseEntity<?> update(@PathVariable(name = "login") String login, @RequestBody Request request) {
        final boolean updated = requestService.update(request, login);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/requests/{login}")
    public ResponseEntity<?> delete(@PathVariable(name = "login") String login) {
        final boolean deleted = requestService.delete(login);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

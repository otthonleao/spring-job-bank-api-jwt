package dev.otthon.jobbank.api.skills.assemblers;

import dev.otthon.jobbank.api.skills.controllers.SkillRestController;
import dev.otthon.jobbank.api.skills.dtos.SkillResponseDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class SkillAssembler implements SimpleRepresentationModelAssembler<SkillResponseDTO> {

    // Para adicionar os links na API Heteoas para um recurso específico
    @Override
    public void addLinks(EntityModel<SkillResponseDTO> resource) {
        var id = resource.getContent().getId();
        var selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(SkillRestController.class)
                .findById(id)
        ).withSelfRel().withType("GET");

        var updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(SkillRestController.class)
                .update(id, null)
        ).withRel("update").withType("PUT");

        var deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(SkillRestController.class)
                .update(id, null)
        ).withRel("update").withType("DELETE");

        resource.add(selfLink, updateLink, deleteLink);
    }

    // Para adicionar os links na API Heteoas para um conjunto de recursos
    @Override
    public void addLinks(CollectionModel<EntityModel<SkillResponseDTO>> resources) {
        var selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SkillRestController.class).findAll(null))
                .withSelfRel()
                .withType("GET");

        var createLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SkillRestController.class).create(null))
                .withRel("create")
                .withType("POST");

        resources.add(selfLink, createLink);
    }

}

set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_reserva;
-- drop procedure if exists usp_recuperar_reserva;
drop procedure if exists usp_insertar_reserva;
drop function if exists fn_generar_id_reserva;
drop procedure if exists usp_modificar_reserva;
drop procedure if exists usp_eliminar_reserva;
delimiter XD
	create procedure usp_listar_reserva(pbuscar varchar(50))
		begin
			select *
			from treserva
			where id_historia like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id reserva
-- crear genero
	create function fn_generar_id_reserva()
				returns int
		begin
			set @id_reserva=(select count(*)from treserva);
				if(@id_reserva=0)then
					return 1;
				else
					begin
						set @id_reserva=(select max(id_reserva)from treserva)+1;
                        return @id_reserva;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_reserva(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from treserva
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_reserva(ptitulo varchar(100),-- el porque de la cita
											pnota text,-- observacion
											pmensaje text,-- mensaje o descripcion
											pfecha_de_cita date,
											phora_de_cita time,
											pprecio double,
											pcreado_en datetime,
											pestado varchar(30),
											ppago varchar(30),
											pid_medico int,
											pid_usuario int,
											pid_historia int,
											pid_especialidad int)
		begin
			set @id_reserva=fn_generar_id_reserva();
			if exists(	select *
					from treserva
					where (id_reserva=@id_reserva))then
				begin
					set @mensaje='error ya existe';
					set @id_error=1;
			end;
			else
				if not exists(	select *
						from tmedico
						where (id_medico=pid_medico))then
					begin
						set @mensaje='error no existe medico';
						set @id_error=1;
				end;
				else
					if not exists(	select *
							from tusuario
							where (id_usuario=pid_usuario))then
						begin
							set @mensaje='error no existe usuario';
							set @id_error=1;
					end;
					else
						if not exists(	select *
								from thistoria
								where (id_historia=pid_historia))then
							begin
								set @mensaje='error no existe historia';
								set @id_error=1;
						end;
						else
							if not exists(	select *
									from tespecialidad
									where (id_especialidad=pid_especialidad))then
								begin
									set @mensaje='error no existe especialidad';
									set @id_error=1;
							end;
							else
								begin
									insert into treserva values(@id_reserva,
																ptitulo,-- el porque de la cita
																pnota,-- observaciones
																pmensaje,-- mensaje o descripcion
																pfecha_de_cita,
																phora_de_cita,
																pprecio,
																false,-- web
																pcreado_en,
																pestado,
																ppago,
																pid_medico,
																pid_usuario,
																pid_historia,
																pid_especialidad);
									set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
									set@id_error=0;
								end;
							end if;
						end if;
					end if;
				end if;
            end if;
            select @mensaje,@id_error;
            select * from treserva;
		end XD 
-- modificar
	
    create procedure usp_modificar_reserva(pid_reserva int,
											ptitulo varchar(100),-- el porque de la cita
											pnota text,-- observacion
											pmensaje text,-- mensaje o descripcion
											pfecha_de_cita date,
											phora_de_cita time,
											pprecio double,
                                            pesta_en_web boolean,
											pcreado_en datetime,
											pestado varchar(30),
											ppago varchar(30),
											pid_medico int,
											pid_usuario int,
											pid_historia int,
											pid_especialidad int)
		begin
			if not exists(	select *
						from treserva
						where (id_reserva=pid_reserva))then
				begin
					set @mensaje='error al modificar';
					set @id_error=1;
				end;
			else
				begin
					update treserva set	titulo=ptitulo,-- el porque de la cita
										nota=pnota,-- observaciones
										mensaje=pmensaje,-- mensaje o descripcion
										fecha_de_cita=pfecha_de_cita,
										hora_de_cita=phora_de_cita,
										precio=pprecio,
										esta_en_web=pesta_en_web,
										creado_en=pcreado_en,
                                        estado=pestado,
                                        pago=ppago,
										id_medico=pid_medico,
										id_usuario=pid_usuario,
										id_historia=pid_historia,
                                        id_especialidad=pid_especialidad
						where id_reserva = pid_reserva;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from treserva;
		end XD 
-- call usp_modificar_reserva('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_reserva(pid_reserva int)
		begin
			if exists (select * from treserva where id_reserva=pid_reserva)then
						delete from treserva where id_reserva=pid_reserva;
					begin
						set @mensaje='existo';
						set @id_error=0;
					end;
			else
				begin
					set @mensaje='no existe reserva';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from treserva;
		end XD
        call usp_eliminar_reserva(1);
        call usp_insertar_reserva('titulo -- el porque de la cita',
									'pnota -- observacion',
									'pmensaje text,-- mensaje o descripcion',
									now(),
									time(now()),
									null,
									now(),
									null,
									null,
									1,
									0,
									1,
									1);
		-- call usp_modificar_reserva(1,'titulo -- el porque de la cita',
									'pnota -- observacion',
									'pmensaje text,-- mensaje o descripcion',
									now(),
									time(now()),
									null,
                                    1,
									now(),
									null,
									null,
									1,
									0,
									1,
									1)
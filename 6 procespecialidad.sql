set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_especialidad;
-- drop procedure if exists usp_recuperar_especialidad;
drop procedure if exists usp_insertar_especialidad;
drop function if exists fn_generar_id_especialidad;
drop procedure if exists usp_modificar_especialidad;
drop procedure if exists usp_eliminar_especialidad;
delimiter XD
	create procedure usp_listar_especialidad(pbuscar varchar(50))
		begin
			select *
			from tespecialidad
			where nombre like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id especialidad
-- crear genero
	create function fn_generar_id_especialidad()
				returns int
		begin
			set @id_especialidad=(select count(*)from tespecialidad);
				if(@id_especialidad=0)then
					return 1;
				else
					begin
						set @id_especialidad=(select max(id_especialidad)from tespecialidad)+1;
                        return @id_especialidad;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_especialidad(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tespecialidad
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_especialidad(pnombre varchar(200),
												pid_categoria int,
												pcreado_en datetime,
												pid_laboratorio int)
		begin
			set @id_especialidad=fn_generar_id_especialidad();
			if exists(	select *
						from tespecialidad
						where (id_especialidad=@id_especialidad))then
				begin
					set @mensaje='error ya existe';
					set @id_error=1;
				end;
			else
				if exists(	select *
						from tespecialidad
						where (nombre=@pnombre))then
				begin
					set @mensaje='error ya existe nombre';
					set @id_error=1;
				end;
				else
					begin
						insert into tespecialidad values(@id_especialidad,
															pnombre ,
															pid_categoria ,
															pcreado_en ,
															pid_laboratorio);
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tespecialidad;
		end XD 
-- modificar
	-- call usp_insertar_especialidad('ped','1',now(),'1')
    create procedure usp_modificar_especialidad(pid_especialidad int,
												pnombre varchar(200),
												pid_categoria int,
												pcreado_en datetime,
												pid_laboratorio int)
		begin
			if not exists(	select *
						from tespecialidad
						where (id_especialidad=pid_especialidad))then
				begin
					set @mensaje='error no existe';
					set @id_error=1;
				end;
			else
				if exists(	select *
						from tespecialidad
						where (nombre=@pnombre))then
				begin
					set @mensaje='error ya existe nombre';
					set @id_error=1;
				end;
				else
					begin
						update tespecialidad set	nombre=pnombre,
													id_categoria=pid_categoria ,
													creado_en=pcreado_en ,
													id_laboratorio=pid_laboratorio 
							where id_especialidad = pid_especialidad;
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tespecialidad;
		end XD 
-- call usp_modificar_especialidad('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_especialidad(pid_especialidad int)
		begin
			if exists (select * from tespecialidad where id_especialidad=pid_especialidad)then
				if not exists(select * from treserva where id_especialidad=pid_especialidad)then
						delete from tespecialidad where id_especialidad=pid_especialidad;
					begin
						set @mensaje='existo';
						set @id_error=0;
					end;
				else
					begin
						set @mensaje='error se encuentra en la tabla reservacion';
						set @id_error=1;
					end;
				end if;
			else
				begin
					set @mensaje='no existe especialidad';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tespecialidad;
		end XD
        call usp_insertar_especialidad('nombre',
										1,
										now(),
										1)
        -- call usp_eliminar_especialidad(1)
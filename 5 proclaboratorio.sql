set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_laboratorio;
-- drop procedure if exists usp_recuperar_laboratorio;
drop procedure if exists usp_insertar_laboratorio;
drop function if exists fn_generar_id_laboratorio;
drop procedure if exists usp_modificar_laboratorio;
drop procedure if exists usp_eliminar_laboratorio;
delimiter XD
	create procedure usp_listar_laboratorio(pbuscar varchar(50))
		begin
			select *
			from tlaboratorio
			where nombre like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id laboratorio
-- crear genero
	create function fn_generar_id_laboratorio()
				returns int
		begin
			set @id_laboratorio=(select count(*)from tlaboratorio);
				if(@id_laboratorio=0)then
					return 1;
				else
					begin
						set @id_laboratorio=(select max(id_laboratorio)from tlaboratorio)+1;
                        return @id_laboratorio;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_laboratorio(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tlaboratorio
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_laboratorio(pnombre varchar(50),
												paforo int,
												pdescripcion text,
												pcreado_en datetime)
		begin
			set @id_laboratorio=fn_generar_id_laboratorio();
			if exists(	select *
						from tlaboratorio
						where (id_laboratorio=@id_laboratorio))then
				begin
					set @mensaje='error ya existe';
					set @id_error=1;
				end;
			else
				begin
					insert into tlaboratorio values(@id_laboratorio,
												pnombre ,
												paforo ,
												pdescripcion ,
												pcreado_en);
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tlaboratorio;
		end XD 
-- modificar
	
    create procedure usp_modificar_laboratorio(pid_laboratorio int,
												pnombre varchar(50),
												paforo int,
												pdescripcion text,
												pcreado_en datetime)
		begin
			if not exists(	select *
						from tlaboratorio
						where (id_laboratorio=pid_laboratorio))then
				begin
					set @mensaje='error no existe';
					set @id_error=1;
				end;
			else
				begin
					update tlaboratorio set	nombre=pnombre,
											aforo=paforo ,
											descripcion=pdescripcion ,
											creado_en=pcreado_en
						where id_laboratorio = pid_laboratorio;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tlaboratorio;
		end XD 
-- call usp_modificar_laboratorio('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_laboratorio(pid_laboratorio int)
		begin
			if exists (select * from tlaboratorio where id_laboratorio=pid_laboratorio)then
				if not exists(select * from tespecialidad where id_laboratorio=pid_laboratorio)then
						delete from tlaboratorio where id_laboratorio=pid_laboratorio;
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
					set @mensaje='no existe laboratorio';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
		end XD
        call usp_insertar_laboratorio('nombre',
										null,
										'descripcion',
										now())
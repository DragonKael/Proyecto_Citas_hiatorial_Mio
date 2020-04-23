set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_historia;
-- drop procedure if exists usp_recuperar_historia;
drop procedure if exists usp_insertar_historia;
drop function if exists fn_generar_id_historia;
drop procedure if exists usp_modificar_historia;
drop procedure if exists usp_eliminar_historia;
delimiter XD
	create procedure usp_listar_historia(pbuscar varchar(50))
		begin
			select *
			from thistoria
			where id_historia like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id historia
-- crear genero
	create function fn_generar_id_historia()
				returns int
		begin
			set @id_historia=(select count(*)from thistoria);
				if(@id_historia=0)then
					return 1;
				else
					begin
						set @id_historia=(select max(id_historia)from thistoria)+1;
                        return @id_historia;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_historia(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from thistoria
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_historia(pid_paciente int,
											pnombre_clinica varchar(100),
											pcreado_en datetime,
											pid_usuario int,
											pid_antecedente int)
		begin
			set @id_historia=fn_generar_id_historia();
			if exists(	select *
						from thistoria
						where (id_historia=@id_historia))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into thistoria values(@id_historia,
												    pid_paciente ,
													pnombre_clinica ,
													pcreado_en ,
													pid_usuario ,
													pid_antecedente );
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from thistoria;
		end XD 
-- modificar
	
    create procedure usp_modificar_historia(pid_historia int,
											pid_paciente int,
											pnombre_clinica varchar(100),
											pcreado_en datetime,
											pid_usuario int,
											pid_antecedente int)
		begin
			if not exists(	select *
						from thistoria
						where (id_historia=pid_historia))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update thistoria set	id_paciente=pid_paciente ,
											nombre_clinica=pnombre_clinica ,
											creado_en=pcreado_en ,
											id_usuario=pid_usuario ,
											id_antecedente=pid_antecedente 
						where id_historia = pid_historia;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from thistoria;
		end XD 
-- call usp_modificar_historia('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_historia(pid_historia int)
		begin
			if exists (select * from thistoria where id_historia=pid_historia)then
				if not exists(select * from treserva where id_historia=pid_historia)then
						delete from thistoria where id_historia=pid_historia;
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
					set @mensaje='no existe historia';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
		end XD
        call usp_eliminar_historia(1);
        call usp_insertar_historia(1,
											'pnombre_clinica ',
											now(),
											0,
											1)
set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_atencion;
-- drop procedure if exists usp_recuperar_atencion;
drop procedure if exists usp_insertar_atencion;
drop function if exists fn_generar_id_atencion;
drop procedure if exists usp_modificar_atencion;
drop procedure if exists usp_eliminar_atencion;
delimiter XD
	create procedure usp_listar_atencion(pbuscar varchar(50))
		begin
			select *
			from tatencion
			where id_atencion like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id atencion
-- crear genero
	create function fn_generar_id_atencion()
				returns int
		begin
			set @id_atencion=(select count(*)from tatencion);
				if(@id_atencion=0)then
					return 1;
				else
					begin
						set @id_atencion=(select max(id_atencion)from tatencion)+1;
                        return @id_atencion;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_atencion(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tatencion
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_atencion(pid_reserva int,
											pid_triaje int,
											pdiagnostico text,
											phora_atencion time)
		begin
			set @id_atencion=fn_generar_id_atencion();
			if exists(	select *
						from tatencion
						where (id_atencion=@id_atencion))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into tatencion values(@id_atencion,
												pid_reserva ,
												pid_triaje ,
												pdiagnostico ,
												phora_atencion);
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tatencion;
		end XD 
-- modificar
	
    create procedure usp_modificar_atencion(pid_atencion int,
											pid_reserva int,
											pid_triaje int,
											pdiagnostico text,
											phora_atencion time)
		begin
			if not exists(	select *
						from tatencion
						where (id_atencion=pid_atencion))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update tatencion set	id_reserva=pid_reserva ,
											id_triaje=pid_triaje ,
											diagnostico=pdiagnostico ,
											hora_atencion=phora_atencion 
						where id_atencion = pid_atencion;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tatencion;
		end XD 
-- call usp_modificar_atencion('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_atencion(pid_atencion int)
		begin
			if exists (select * from tatencion where id_atencion=pid_atencion)then
				if not exists(select * from treceta where id_atencion=pid_atencion)then
						delete from tatencion where id_atencion=pid_atencion;
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
					set @mensaje='no existe atencion';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tatencion;
		end XD
        call usp_eliminar_atencion(1);
        call usp_insertar_atencion(1,
									1,
									'diagnostico',
									time(now()))
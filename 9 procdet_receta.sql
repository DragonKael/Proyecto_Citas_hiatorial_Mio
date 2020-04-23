set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_det_receta;
-- drop procedure if exists usp_recuperar_det_receta;
drop procedure if exists usp_insertar_det_receta;
drop function if exists fn_generar_id_det_receta;
drop procedure if exists usp_modificar_det_receta;
drop procedure if exists usp_eliminar_det_receta;
delimiter XD
	create procedure usp_listar_det_receta(pbuscar varchar(50))
		begin
			select *
			from tdet_receta;
-- 			where nombre like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id det_receta
-- crear genero
	create function fn_generar_id_det_receta()
				returns int
		begin
			set @id_det_receta=(select count(*)from tdet_receta);
				if(@id_det_receta=0)then
					return 1;
				else
					begin
						set @id_det_receta=(select max(id_det_receta)from tdet_receta)+1;
                        return @id_det_receta;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_det_receta(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tdet_receta
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_det_receta(pcantidad int,
												pdosis text,
												pfrecuencia text, 
												pid_medicamento int,
												pid_receta int)
		begin
			set @id_det_receta=fn_generar_id_det_receta();
			if exists(	select *
						from tdet_receta
						where (id_det_receta=@id_det_receta))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into tdet_receta values(@id_det_receta,
													pcantidad ,
													pdosis ,
													pfrecuencia , 
													pid_medicamento ,
													pid_receta);
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tdet_receta;
		end XD 
-- modificar
	
    create procedure usp_modificar_det_receta(pid_det_receta int,
												pcantidad int,
												pdosis text,
												pfrecuencia text, 
												pid_medicamento int,
												pid_receta int)
		begin
			if not exists(	select *
						from tdet_receta
						where (id_det_receta=pid_det_receta))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update tdet_receta set	cantidad=pcantidad ,
											dosis=pdosis ,
											frecuencia=pfrecuencia , 
											id_medicamento=pid_medicamento ,
											id_receta=pid_receta 
						where id_det_receta = pid_det_receta;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tdet_receta;
		end XD 
-- call usp_modificar_det_receta('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_det_receta(pid_det_receta int)
		begin
			if exists (select * from tdet_receta where id_det_receta=pid_det_receta)then
				
						delete from tdet_receta where id_det_receta=pid_det_receta;
					begin
						set @mensaje='existo';
						set @id_error=0;
					end;
			else
				begin
					set @mensaje='no existe det_receta';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;	
            select * from tdet_receta;
		end XD
        call usp_eliminar_det_receta(1);
        call usp_insertar_det_receta(0,
									'pdosis text,',
												'pfrecuencia text, ',
												1,
												1)
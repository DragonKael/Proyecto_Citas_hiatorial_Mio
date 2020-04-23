set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_receta;
-- drop procedure if exists usp_recuperar_receta;
drop procedure if exists usp_insertar_receta;
drop function if exists fn_generar_id_receta;
drop procedure if exists usp_modificar_receta;
drop procedure if exists usp_eliminar_receta;
delimiter XD
	create procedure usp_listar_receta(pbuscar varchar(50))
		begin
			select *
			from treceta
			where id_receta like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id receta
-- crear genero
	create function fn_generar_id_receta()
				returns int
		begin
			set @id_receta=(select count(*)from treceta);
				if(@id_receta=0)then
					return 1;
				else
					begin
						set @id_receta=(select max(id_receta)from treceta)+1;
                        return @id_receta;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_receta(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from treceta
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_receta(pinterno boolean,
											ptiempo_tratamiento text,
											pid_atencion int)
		begin
			set @id_receta=fn_generar_id_receta();
			if exists(	select *
						from treceta
						where (id_receta=@id_receta))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into treceta values(@id_receta,
												pinterno ,
                                                ptiempo_tratamiento,
												pid_atencion);
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from treceta;
		end XD 
-- modificar
	
    create procedure usp_modificar_receta(pid_receta int,
											pinterno boolean,
                                            ptiempo_tratamiento text,
											pid_atencion int)
		begin
			if not exists(	select *
						from treceta
						where (id_receta=pid_receta))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update treceta set	interno=pinterno ,
										tiempo_tratamiento=ptiempo_tratamiento,
										id_atencion=pid_atencion 
						where id_receta = pid_receta;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from treceta;
		end XD 
-- call usp_modificar_receta('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_receta(pid_receta int)
		begin
			if exists (select * from treceta where id_receta=pid_receta)then
				if not exists(select * from tdet_receta where id_receta=pid_receta)then
						delete from treceta where id_receta=pid_receta;
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
					set @mensaje='no existe receta';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;
            select * from treceta;
		end XD
        call usp_eliminar_receta(1);
        call usp_insertar_receta(true,
								'ptiempo_tratamiento text',
								1)
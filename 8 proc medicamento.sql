set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_medicamento;
-- drop procedure if exists usp_recuperar_medicamento;
drop procedure if exists usp_insertar_medicamento;
drop function if exists fn_generar_id_medicamento;
drop procedure if exists usp_modificar_medicamento;
drop procedure if exists usp_eliminar_medicamento;
delimiter XD
	create procedure usp_listar_medicamento(pbuscar varchar(50))
		begin
			select *
			from tmedicamento
			where nombre like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id medicamento
-- crear genero
	create function fn_generar_id_medicamento()
				returns int
		begin
			set @id_medicamento=(select count(*)from tmedicamento);
				if(@id_medicamento=0)then
					return 1;
				else
					begin
						set @id_medicamento=(select max(id_medicamento)from tmedicamento)+1;
                        return @id_medicamento;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_medicamento(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tmedicamento
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_medicamento(pnombre varchar(50),
												ptipo varchar(100),
                                                pmedio varchar(50),
                                                punidad_medida varchar(10),
												pdescripcion text)
		begin
			set @id_medicamento=fn_generar_id_medicamento();
			if exists(	select *
						from tmedicamento
						where (id_medicamento=@id_medicamento))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into tmedicamento values(@id_medicamento,
												pnombre,
                                                ptipo,
												pmedio,
                                                punidad_medida ,
												pdescripcion );
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tmedicamento;
		end XD 
-- modificar
	
    create procedure usp_modificar_medicamento(pid_medicamento int,
												pnombre varchar(50),
												ptipo varchar(100),
                                                pmedio varchar(50),
                                                punidad_medida varchar(10),
												pdescripcion text)
		begin
			if not exists(	select *
						from tmedicamento
						where (id_medicamento=pid_medicamento))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update tmedicamento set	nombre=pnombre,
                                            tipo=ptipo,
                                            medio=pmedio,
                                            unidad_medida=punidad_medida ,
											descripcion=pdescripcion
						where id_medicamento = pid_medicamento;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from tmedicamento;
		end XD 
-- call usp_modificar_medicamento('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_medicamento(pid_medicamento int)
		begin
			if exists (select * from tmedicamento where id_medicamento=pid_medicamento)then
				if not exists(select * from tdet_receta where id_medicamento=pid_medicamento)then
						delete from tmedicamento where id_medicamento=pid_medicamento;
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
					set @mensaje='no existe medicamento';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;	
            select * from tmedicamento;
		end XD
        call usp_eliminar_medicamento(1);
        call usp_insertar_medicamento('nombre',
										'tipo ',
                                        'medio',
                                        'um ',
										'descripcion')
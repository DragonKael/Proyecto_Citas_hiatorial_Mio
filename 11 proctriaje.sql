set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_triaje;
-- drop procedure if exists usp_recuperar_triaje;
drop procedure if exists usp_insertar_triaje;
drop function if exists fn_generar_id_triaje;
drop procedure if exists usp_modificar_triaje;
drop procedure if exists usp_eliminar_triaje;
delimiter XD
	create procedure usp_listar_triaje(pbuscar varchar(50))
		begin
			select *
			from ttriaje
			where id_triaje like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id triaje
-- crear genero
	create function fn_generar_id_triaje()
				returns int
		begin
			set @id_triaje=(select count(*)from ttriaje);
				if(@id_triaje=0)then
					return 1;
				else
					begin
						set @id_triaje=(select max(id_triaje)from ttriaje)+1;
                        return @id_triaje;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_triaje(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from ttriaje
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_triaje(ppeso double,																					
											ptalla double,
                                            ppresion_sanguinea double,
                                            pnivel varchar(9),
											pcolor varchar (10),
											pcategoria varchar(25),
											ptiempo_atencion varchar(50),
											pdetalles text)
		begin
			set @id_triaje=fn_generar_id_triaje();
			if exists(	select *
						from ttriaje
						where (id_triaje=@id_triaje))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					insert into ttriaje values(@id_triaje,
												ppeso,																					
												ptalla,
												ppresion_sanguinea,
                                                pnivel ,
												pcolor ,
												pcategoria ,
												ptiempo_atencion ,
												pdetalles );
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from ttriaje;
		end XD 
-- modificar
	
    create procedure usp_modificar_triaje(pid_triaje int,
											ppeso double,																					
											ptalla double,
                                            ppresion_sanguinea double,
                                            pnivel varchar(9),
											pcolor varchar (10),
											pcategoria varchar(25),
											ptiempo_atencion varchar(50),
											pdetalles text)
		begin
			if not exists(	select *
						from ttriaje
						where (id_triaje=pid_triaje))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				begin
					update ttriaje set	peso=ppeso,																					
										talla=ptalla,
										presion_sanguinea=ppresion_sanguinea,
                                        nivel=pnivel ,
										color=pcolor ,
										categoria=pcategoria ,
										tiempo_atencion=ptiempo_atencion,
										detalles=pdetalles
						where id_triaje = pid_triaje;
					set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
					set@id_error=0;
				end;
			end if;
			select @mensaje,@id_error;
            select * from ttriaje;
		end XD 
-- call usp_modificar_triaje('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_triaje(pid_triaje int)
		begin
			if exists (select * from ttriaje where id_triaje=pid_triaje)then
				if not exists(select * from tatencion where id_triaje=pid_triaje)then
						delete from ttriaje where id_triaje=pid_triaje;
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
					set @mensaje='no existe triaje';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
            select * from ttriaje;
		end XD
        call usp_eliminar_triaje(1);
        call usp_insertar_triaje(0,																					
									0,
									0,
									'',
									'',
									'',
									'',
									'detalles')